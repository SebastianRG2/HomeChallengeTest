import http from 'k6/http';
import { check } from 'k6';
import { sleep } from 'k6';
import { Counter } from 'k6/metrics';

export const options = {
    stages: [
        { target: 5, duration: '1m' }, 
        { target: 5, duration: '2m' }, 
        { target: 0, duration: '1m' }, 
    ],
    thresholds: {
        "http_req_failed": ['rate<0.01'], 
        "http_req_duration": ["p(95)<1000"], 
    },
};

var myErrorCounter = new Counter("error_500");
var mySucess = new Counter("success_200");

export default function () {
    let responses = http.request('GET', 'http://localhost:8080/api/v3/store/inventory', { headers: { 'Content-Type': 'application/json' } });

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
