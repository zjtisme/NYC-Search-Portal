Simple Searching App for NYC city

User can sign up, log in, configure profile, delete account, and log out

User can search for 50 latest news based on inputs and user can do this without logging in


nyc-search-ui:
   image: node
   ports:
    - "3000:3000"
   working_dir: /app
   volumes:
    - ./nyc-search-ui:/app
   command: 'npm start'
   depends_on:
     - app
     - postgresdev
