# Travel Management System

## Overview

The Travel Management System is a desktop application developed in Java, leveraging Swing and AWT packages for the frontend interface and MySQL for the backend database. This application facilitates the management of travel-related information including bookings, customer details, and itinerary management. It implements core Java concepts such as multithreading, Runnable interfaces, and Java Database Connectivity (JDBC) to ensure efficient performance and seamless integration with the database.

## Features

- User-friendly graphical interface developed using Java Swing and AWT packages.
- Secure and efficient storage and retrieval of data using MySQL database.
- Multithreading support for concurrent processing tasks, enhancing application performance.
- Seamless connectivity to the database using JDBC for robust data management.

## Images

<img src="https://media.licdn.com/dms/image/D4D2DAQFeEg5Iak5hIA/profile-treasury-image-shrink_800_800/0/1689098287119?e=1713600000&v=beta&t=b77gYhkG7HjjQDPEC2YOWvNXCiT2Hbdcw-re1pkvWnw" />

## Requirements

- Java Development Kit (JDK) installed on your system.
- MySQL database server.
- MySQL Connector/J library for JDBC connectivity.

## Setup

1. **Database Configuration**:
   - Ensure that MySQL is installed and running on your system.
   - Create a new database named `travel_management_system`.
   - Import the provided `database.sql` file to create the necessary tables and populate initial data.

2. **JDBC Configuration**:
   - Add the MySQL Connector/J library to your project's build path.
   - Configure JDBC connection properties in the `db.properties` file.

3. **Build and Run**:
   - Compile the Java files using your preferred IDE or command-line compiler.
   - Run the main application file to launch the Travel Management System.
  
## Usage

Upon launching the application, users will be greeted with a user-friendly interface where they can perform various tasks such as:

- Add, edit, or delete travel bookings.
- Manage customer information and preferences.
- Generate and manage travel itineraries.
- View and update booking status and details.
- Perform administrative tasks such as user management and system settings.
