<!-- <a href="https://aimeos.org/">
    <img src="https://aimeos.org/fileadmin/template/icons/logo.png" alt="Aimeos logo" title="Aimeos" align="right" height="60" />
</a> -->

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
-   [Installation setup](#installation-setup)
    -   [Frontend](#frontend)
    -   [Backend](#backend)
-   [Api EndPoints](#api-endpoints)
-   [License](#license)
-   [Links](#links)

## Built With

Xiaomi Ode2Code 3.0 is developed using the following technologies:

-   Frontend: React.js, HTML, Tailwind CSS
-   Backend: Java with Spring Boot Framework

## Prerequisites

Before you begin, ensure you have the following prerequisites for both the frontend and backend components of the project.

### Frontend

-   Node.js 16 LTS and npm installed

### Backend

-   Java Development Kit (JDK)
-   gradlew or InteliJ Idea

## Installation & Setup

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

##

## License

## Links

-

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->

[forks-shield]: https://img.shields.io/github/forks/othneildrew/Best-README-Template.svg?style=for-the-badge
[forks-url]: https://github.com/othneildrew/Best-README-Template/network/members
[stars-shield]: https://img.shields.io/github/stars/othneildrew/Best-README-Template.svg?style=for-the-badge
[stars-url]: https://github.com/othneildrew/Best-README-Template/stargazers
[issues-shield]: https://img.shields.io/github/issues/othneildrew/Best-README-Template.svg?style=for-the-badge
[issues-url]: https://github.com/othneildrew/Best-README-Template/issues
[license-shield]: https://img.shields.io/github/license/othneildrew/Best-README-Template.svg?style=for-the-badge
[license-url]: https://github.com/othneildrew/Best-README-Template/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/othneildrew
[React.js]: https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB
