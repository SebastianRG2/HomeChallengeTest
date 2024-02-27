# **Home Challenge Performance Visa**

## Introduction 🚀

Remember the results is in: [Results](RESULTS.MD)

This document will explain the necessary configurations to run the project, as well as the purpose of each type of test. (Here, the results will not be shown; for that, there is another separate document called RESULTS.MD)

## Preconditions 📋

---

- Install K6: brew install k6
- Install Plugin for reports: 
    + ```Install Go toolchain in https://go.dev/doc/install```
    + ```Execute: go install go.k6.io/xk6/cmd/xk6@latest```
    + ```xk6 build --with github.com/grafana/xk6-dashboard@latest```
    + ```If the previous step gives you trouble, don't forget to install the PATH: export PATH=$(go env GOPATH)/bin:$PATH```
- Install Visual Studio Code

---

## Reports

To generate a new report, you must execute the following command:
k6 run --out web-dashboard=report=pet-create-smoke-test.html script.js

The results are stored in the folder:
**K6 reports** ```performance-test/results``

---

## VCS 🔀

---
Git is used as a version control system.

## Load test 

Load testing simulates the expected number of users and traffic that an application could experience in a production environment. They evaluate the performance of your system and ensure it meets predefined performance metrics, such as SLAs. Setting performance goals and tracking metrics over time ensures that your application's performance does not inadvertently degrade as the system evolves.

**Purpose**: Performance testing aims to examine the responsiveness, speed, and overall functionality of a software application under specific conditions. Think of it like taking a high-performance sports car to its limits on a racetrack to assess how well it handles, measure its top speed, and ensure it performs flawlessly under all circumstances.

**Objectives**: The main objective of performance testing is to ensure that a software application operates efficiently and provides a seamless user experience. It seeks to uncover bottlenecks, assess resource utilization, and identify areas for improvement.

**Metrics**: Performance testing metrics include response time (how quickly the system responds to user actions), throughput (the number of transactions processed per unit of time), resource utilization (how efficiently the system uses CPU, memory, and other resources), and scalability (the system's ability to handle increased load by adding resources).

**How does the application behave under load?**
CPU usage, memory usage, network usage, disk usage, etc., are measured.

**How many errors are generated?**
It is the ratio of successful/failed transactions to all transactions.

**What is the response time?**
It is the time taken for a request to be sent and a response to be returned. Improved website/application performance correlates with faster response times.

**Requests per second?**
It is the amount of time a request spends waiting in line to be processed.

---

## Stress Tests 

They help determine how your system behaves under extremely heavy load. These tests can be useful for identifying the maximum load your system can withstand before reaching the breaking point, and they can also help identify the bottlenecks leading to failure.

The load pattern of a stress test resembles that of an average load test. The main difference is a higher load. To account for a higher load, the ramp-up period takes longer in proportion to the increase in load. Similarly, once the test reaches the desired load, it may last a little longer than in the average load test.

**Purpose**: Stress tests, on the other hand, focus on evaluating a system's ability to handle a predefined volume of users or concurrent requests.

**Objectives**: The main objective of stress tests is to identify the maximum load a system can handle without degradation or performance failure. It helps developers and system administrators plan for scalability and ensure the system can adapt to expected user loads.

**Metrics**: Stress test metrics include concurrent users (the number of users accessing the system simultaneously), requests per second (RPS, measuring the rate of incoming requests), transaction rates (how many transactions the system can process per unit of time), and error rates (tracking the occurrence of errors under stress).

---

## Smoke Tests

They help determine how your system performs under sustained long-term load. These tests can be useful for identifying memory leaks or other issues related to resource limitations that deplete over time.

Smoke tests have minimal load. They are executed to verify that the system performs well under minimal load and to collect basic performance metrics.

This type of test involves running tests with a few VUs; more than 5 VUs could be considered a mini-load test.

---

## Execute
k6 run --out web-dashboard=report=test-report-create-user-load-report.html  /scripts/load-test/create-user-load-test.js

## Contributor
* **Sebastian Ramirez** - [Contact](mailto:sebastianramirez.g@outlook.com)
---
