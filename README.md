# Backend IC Spring Boot

Spring Boot API for the Constitution Learning Platform frontend.

## Requirements

- Java 21 or newer
- MySQL 8 running locally
- Maven, included locally in `.tools`

## Database Setup

Run this once:

```bat
create-database.bat
```

Enter your MySQL admin username and password when prompted. The script creates:

- Database: `ic_project_db`
- App user: `ic_user`
- App password: `ic_password`

## Run

```bash
mvn spring-boot:run
```

Since Maven is installed locally in this project folder, on Windows you can also run:

```bat
run-backend.bat
```

The API runs at:

```txt
http://localhost:5000/api
```

## Railway Deployment

This repo includes `railway.json` and `system.properties` for Railway.

Deploy steps:

1. Push this backend repo to GitHub.
2. Open Railway and create a new project from the GitHub repo.
3. Add a Railway MySQL database service.
4. In the backend service, add these environment variables:

```txt
DB_URL=jdbc:mysql://${{MySQL.MYSQLHOST}}:${{MySQL.MYSQLPORT}}/${{MySQL.MYSQLDATABASE}}?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
DB_USERNAME=${{MySQL.MYSQLUSER}}
DB_PASSWORD=${{MySQL.MYSQLPASSWORD}}
FRONTEND_ORIGIN=https://your-vercel-frontend-url.vercel.app
```

Railway provides `PORT` automatically. The app uses it through:

```properties
server.port=${PORT:5000}
```

After deployment, your backend health URL will be:

```txt
https://your-railway-backend-url/api/health
```

Use that Railway backend URL in your Vercel frontend variable:

```txt
VITE_API_BASE_URL=https://your-railway-backend-url/api
```

## Demo Login

| Role | Email | Password |
| --- | --- | --- |
| Admin | admin@example.com | admin123 |
| Educator | educator@example.com | educator123 |
| Citizen | citizen@example.com | citizen123 |
| Legal Expert | expert@example.com | expert123 |

## Endpoints

- `GET /api/health`
- `POST /api/auth/login`
- `POST /api/auth/register`
- `GET /api/users`
- `GET /api/dashboard/{role}`
- `GET /api/content/articles`
- `GET /api/content/constitution-parts`
- `GET /api/content/fundamental-rights`
- `GET /api/content/fundamental-duties`
- `GET /api/content/directive-principles`
- `GET /api/content/legal-faq`
- `GET /api/quiz`
- `POST /api/quiz/submit`
- `GET /api/forum/posts`
- `POST /api/forum/posts`
- `GET /api/legal-guidance`
