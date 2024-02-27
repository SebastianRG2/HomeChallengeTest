import http from 'k6/http';
import { check, sleep } from 'k6';
import papaparse from 'https://jslib.k6.io/papaparse/5.1.1/index.js';
import { Counter } from 'k6/metrics';

export const options = {
    executor: 'constant-arrival-rate',
    stages: [
        { target: 5, duration: '30s' },
        { target: 5, duration: '1m' },
        { target: 0, duration: '10s' },
    ],
    thresholds: {
        "http_req_failed": ['rate<0.01'], 
        "http_req_duration": ["p(100)<1000"], 
    },
};


var myErrorCounter = new Counter("error_500");
var mySucess = new Counter("success_200");

const csvData = papaparse.parse(open('./create.csv'), { header: true }).data;

export default function () {

    let randomUser = csvData[Math.floor(Math.random() * csvData.length)];
    console.log('Random user: ', JSON.stringify(randomUser));
    console.log('randomUser ID: ', randomUser.Id);

    let responses = http.request('POST', 'http://localhost:8080/api/v3/user', JSON.stringify({
        "id": randomUser.Id,
        "username": randomUser.Username,
        "firstName": randomUser.FirstName,
        "lastName": randomUser.LastName,
        "email": randomUser.Email,
        "password": randomUser.Password,
        "phone": randomUser.Phone,
        "userStatus": 1
    }), { headers: { 'Content-Type': 'application/json' } });

    if (responses.status === 200) {
      mySucess.add(1);
    }
    
    if (responses.status >= 500) {
      myErrorCounter.add(1);
    }
    check(responses, {
        'status was 200': (r) => r.status === 200,
    });
    sleep(30)
}