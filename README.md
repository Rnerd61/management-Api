# Xiaomi Parts-management project

[![License](https://poser.pugx.org/aimeos/aimeos-typo3/license.svg)](https://www.gnu.org/licenses/agpl-3.0.en.html)

<!-- :star: Star us on GitHub — it motivates us a lot! -->

This project is part of [Ode2Code 3.0](https://unstop.com/competitions/xiaomi-ode2code-30-xiaomi-india-713806) competition organized by [Xiaomi](https://www.mi.com). This is frontend of the project developed using Reactjs, tailwind, axios and a template provided by windmill. Frontend includes login, register, profile pages and dashboard for all 4 types of stakeholders. (Planning, Warehouse, Service Centres, and Customer Support teams.).

-   Service centers can create spare parts request and access spare parts available, add spare parts, add customers.
-   Warehouse receives request from service centers via planning team and dispatches the parts to service centers.
-   Planning team will recieve parts request from service centers and assign warehouse to the queries.
-   Customer Support Team will have access to available parts at different service centers and can assign/send a customer to a service center as per parts requirement.

## Table Of Content

-   [Built With](#built-with)
-   [Prerequesites](#prerequesites)
    -   [Frontend](#frontend)
    -   [Backend](#backend)
-   [Installation Setup](#installation-setup)
    -   [Frontend](#frontend)
    -   [Backend](#backend)
-   [Api EndPoints](#api-endpoints)
    -   [Authentication](#authentication)
    -   [Service Team](#service-team)
    -   [Planning Team](#planning-team)
    -   [Warehouse Team](#warehouse-team)
    -   [Customer Support Team](#customer-support-team)
-   [User Types and Use-Cases](#user-types-and-use-cases)
-   [License](#license)
-   [Links](#links)

## Built With

Xiaomi Ode2Code 3.0 is developed using the following technologies:

-   Frontend: React.js, HTML, Tailwind CSS
-   Backend: Java with Spring Boot Framework

## Prerequesites

Before you begin, ensure you have the following prerequisites for both the frontend and backend components of the project.

### Frontend

-   Node.js 16 LTS and npm installed

### Backend

-   Java Development Kit (JDK)
-   gradlew or InteliJ Idea

## Installation Setup

Default port for frontend is 3000, and for backend 8000.

Follow these steps to set up the Xiaomi Ode2Code 3.0 project on your local machine.

### Frontend

1. Run the following command to install dependencies:

    ```shell
    git clone https://github.com/Patel-Aman/parts-management
    cd parts-management
    npm install
    npm start
    ```

    Alternatively yarn can also be used.

### Backend

1. Run the following commands to start backend:
    ```shell
    git clone https://github.com/Rnerd61/management-Api
    cd management-Api
    ./gradlew build
    ./gradlew bootRun
    ```
    alternatively open cloned folder in InteliJ Idea.

## Api Endpoints

</span> <span style="font-size: 18px;">[postman](https://app.getpostman.com/join-team?invite_code=aadcaba11f25ae0f27b3b7e90969b199&target_code=8cdb5b23807701c4edf899ab36f16724)</span> endpoints collection

### Authentication

-   `/api/v1/auth/register` - To create new employee
-   `/api/v1/auth/login` - Employee Login
-   `/api/v1/auth/user` - Get details of Logged in Employee

### Service team

-   `/api/v1/sc/customer` - Create New customer
-   `/api/v1/sc/customer/RequiredPart` - Add required part for the customer
-   `/api/v1/sc/AvailableParts` - Check Availability of parts in its stock
-   `/api/v1/sc/UsedParts` - If available use that part accordance to customer requirement
-   `/api/v1/sc/ReqPart` - If not send request to planning team for parts and its quantity

### Planning team

-   `/api/v1/pt/getAllPlanningTasks` - fetch all pending planning tasks
-   `/api/v1/pt/getRequests` - fetch all incoming requests from service centers
-   `/api/v1/pt/createPlanningTask` - create a planning schedule from incoming requests
-   `/api/v1/pt/forward` - forward request to closest warehouses after checking availability of parts
-   `/api/v1/pt/{id}` - get, update and delete planning task by id

### Warehouse team

-   `/api/v1/wt/AvailabilityCheck` - check availability of parts
-   `/api/v1/wt/dispatch` - dispatch required parts to service center
-   `/api/v1/wt/delivered` - status update after delivery

### Customer Support Team

-   `/api/v1/cs/` - get all inquiries
-   `/api/v1/cs/hello` - initiate chat
-   `/api/v1/cs/{id}` - get, delete, update inquiry by id

## User Types and Use-Cases

1. **Service Centers**

    - Create Job Sheets for customers.
    - Diagnose devices and identify parts requirements.
    - Consume available parts for repairs.
    - Send part requests for unavailable parts.

2. **Planning Team**

    - Identify daily part requirements from service centers.
    - Check part availability across warehouses.
    - Prepare material dispatch plans.

3. **Warehouse Team**

    - Dispatch materials to service centers based on plans.
    - Receive and map parts to repair orders.

4. **Customer Support** - Address customer queries about repair orders.
