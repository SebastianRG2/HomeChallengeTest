import http from 'k6/http';
import { check } from 'k6';
import { sleep } from 'k6';
import { Counter } from 'k6/metrics';

export const options = {
    executor: 'constant-arrival-rate',
    stages: [
        { target: 5, duration: '40s' },
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

export default function () {

const randomId = Math.floor(Math.random() * 100); 
const randomName = `doggie_${randomId}`; 

let data = JSON.stringify({
    "id": randomId,
    "name": randomName,
    "category": {
        "id": 1,
        "name": "Dogs"
    },
    "photoUrls": [
        "string"
    ],
    "tags": [
        {
            "id": 0,
            "name": "string"
        }
    ],
    "status": "available"
});

let responses = http.request('POST','http://localhost:8080/api/v3/pet',data,{ headers: { 'Content-Type': 'application/json' } });
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

