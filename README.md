# AI Resume Builder

Welcome to the AI Resume Builder project! This backend application is designed to help users generate professional resumes tailored to specific job descriptions using advanced natural language processing and AI capabilities.

## Features

- **Custom Resume Generation**: Users can input their existing resume, job description, and specific instructions to create a tailored resume.
- **Advanced AI Integration**: Utilizes OpenAI's language models to craft high-quality impact-oriented resumes optimized for ATS screening.
- **Format Support**: Supports multiple file formats including `.pdf`, `.docx`, `.doc`, and `.txt`.
- **User Authentication**: Supports user registration and login for personalized services.
- **Modular Design**: Includes modular services for text extraction, user management, and resume generation.

## Project Structure

The backend application is developed in **Java** using the **Spring Boot** framework. Below is an overview of the project structure:

### 1. Controllers

#### **ResumeBuilderController**
Handles HTTP POST requests to `/api/generateResume`, allowing users to generate tailored resumes. It processes user input (uploaded resume file, job description file/text, and additional instructions) and passes it to the services for AI-based resume generation.

#### **ChatController**
Communicates with OpenAI's API to generate responses based on the constructed prompts. It exposes an endpoint `/api/llm/generate` for AI interaction.

#### **UserLoginController**
Provides endpoints for user registration (`/api/register`) and login (`/api/login`).

### 2. Services

#### **ResumeBuilderService**
Processes user input by extracting text from files (resume or job description) and combines it with user instructions to create the input for the AI model.

#### **HelperService**
Handles text extraction from various file formats:
- `.pdf` using PDFBox
- `.docx` using Apache POI
- `.doc` using Apache POI HWPF
- `.txt` using standard UTF-8 encoding
- Other formats using Apache Tika

#### **LLMService**
Constructs prompts for the AI model using resume content, job description, and user instructions. Implements enhanced output requirements such as structuring resumes into clear sections, quantifying achievements, and optimizing for ATS screening.

#### **UserService**
Manages user operations:
- Registration: Ensures unique email addresses and stores user details.
- Login: Validates user credentials.
- Fetching User Details: Retrieves user data and chat history.

### 3. Mappers

#### **UserToDto**
Maps `UserEntity` objects to `UserDto` objects for simplified data handling.

### 4. Models

#### **UserEntity**
Represents user data in the database.

#### **UserDto**
Data Transfer Object for user information.

### 5. External Libraries

- **Spring Boot**: Backend framework for application development.
- **PDFBox**: For PDF text extraction.
- **Apache POI**: For `.docx` and `.doc` text extraction.
- **Apache Tika**: For handling other file formats.
- **OpenAI API**: For AI-based resume generation.

## Setup and Usage

### Prerequisites
- Java 8 or higher
- Maven
- OpenAI API Key

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/DarkLord-13/AI_Resume_Builder.git
   ```
2. Navigate to the project directory:
   ```bash
   cd AI_Resume_Builder
   ```
3. Build the project:
   ```bash
   mvn clean install
   ```

### Running the Application

1. Start the application:
   ```bash
   mvn spring-boot:run
   ```
2. Access the endpoints:
   - `POST /api/generateResume` for resume generation.
   - `POST /api/register` for user registration.
   - `POST /api/login` for user login.

### API Endpoints

#### Resume Generation
- **Endpoint**: `/api/generateResume`
- **Method**: `POST`
- **Parameters**:
  - `resumeFile` (optional): User's existing resume file.
  - `jdFile` (optional): Job description file.
  - `jdText` (optional): Job description text.
  - `instructions` (required): Additional formatting instructions.
- **Response**:
  - Success: Returns the generated resume in plain text.
  - Failure: Returns a 500 error with a failure message.

#### User Registration
- **Endpoint**: `/api/register`
- **Method**: `POST`
- **Body**:
  ```json
  {
    "name": "John Doe",
    "email": "john.doe@example.com",
    "password": "securepassword"
  }
  ```
- **Response**:
  - Success: `201 Created`
  - Failure: `500 Internal Server Error`

#### User Login
- **Endpoint**: `/api/login`
- **Method**: `POST`
- **Body**:
  ```json
  {
    "email": "john.doe@example.com",
    "password": "securepassword"
  }
  ```
- **Response**:
  - Success: `200 OK`
  - Failure: `401 Unauthorized`

#### AI Interaction
- **Endpoint**: `/api/llm/generate`
- **Method**: `GET`
- **Parameters**:
  - `prompt`: AI prompt for resume generation.
- **Response**:
  - Returns AI-generated text.

## Contribution

Contributions are welcome! Please follow these steps:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/your-feature`).
3. Commit your changes (`git commit -m 'Add your feature'`).
4. Push to the branch (`git push origin feature/your-feature`).
5. Create a pull request.

## License

This project is currently not licensed. Please contact the repository owner for licensing inquiries.

## Contact

For any queries, please contact [DarkLord-13](https://github.com/DarkLord-13).
