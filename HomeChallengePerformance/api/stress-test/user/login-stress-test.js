import http from 'k6/http';
import { check } from 'k6';
import { sleep } from 'k6';
import papaparse from 'https://jslib.k6.io/papaparse/5.1.1/index.js';
import { Counter } from 'k6/metrics';

export const options = {
    stages: [
        { target: 30, duration: '5m' }, 
        { target: 30, duration: '5m' }, 
        { target: 0, duration: '1m' }, 
    ],
    thresholds: {
        "http_req_failed": ['rate<0.01'], 
        "http_req_duration": ["p(95)<1000"],
    },
};

const csvData = papaparse.parse(open('./login.csv'), { header: true }).data;

var myErrorCounter = new Counter("error_500");
var mySucess = new Counter("success_200");

export default function () {

    let randomUser = csvData[Math.floor(Math.random() * csvData.length)];

    const params = {
        headers: {
            'accept': 'application/xml',
            'Content-Type': 'application/json',
        },
        params: {
            username: randomUser.Username,
            password: randomUser.Password,
        },
    };

    let responses = http.request('GET', 'http://localhost:8080/api/v3/user/login', params);

    console.log('Response: ', JSON.stringify(responses));


    if (responses.status === 200) {
        mySucess.add(1);
      }
      
      if (responses.status >= 500) {
        myErrorCounter.add(1);
      }

    check(responses, {
        'status was 200': (r) => r.status === 200,
    });
    sleep(5);
}