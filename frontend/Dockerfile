# Use an official Node.js image as the base
FROM node:18

# Set the working directory inside the container
WORKDIR /app

# Install Angular CLI globally
RUN npm install -g @angular/cli@18

# Expose port 4200 for Angular app (default port for Angular dev server)
EXPOSE 4200

# Set up a default command for your container
CMD [ "ng", "version" ]
