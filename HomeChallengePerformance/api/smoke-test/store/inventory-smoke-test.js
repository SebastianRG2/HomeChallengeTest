import http from 'k6/http';
import { check } from 'k6';
import { sleep } from 'k6';

export const options = {
    vus: 2, 
    duration: '1m',
    thresholds: {
        "http_req_failed": ['rate<0.01'], 
        "http_req_duration": ["p(100)<1000"], 
    },
};

export default function () {

    let responses = http.request('GET', 'http://localhost:8080/api/v3/store/inventory', { headers: { 'Content-Type': 'application/json' } });

    check(responses, {
        'status was 200': (r) => r.status === 200,
    });
    sleep(1);
}