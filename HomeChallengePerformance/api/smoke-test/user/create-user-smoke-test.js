import http from 'k6/http';
import { check } from 'k6';
import papaparse from 'https://jslib.k6.io/papaparse/5.1.1/index.js';
import { sleep } from 'k6';

export const options = {
    vus: 1, 
    duration: '1m',
    thresholds: {
        "http_req_failed": ['rate<0.01'], 
        "http_req_duration": ["p(100)<1000"], 
    },
};

const csvData = papaparse.parse(open('./create.csv'), { header: true }).data;

export default function () {

    let randomUser = csvData[Math.floor(Math.random() * csvData.length)];

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

    console.log('Response: ', JSON.stringify(responses));

    check(responses, {
        'status was 200': (r) => r.status === 200,
    });
    sleep(1);
}

