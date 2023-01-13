# Dockerfile
FROM node:16.19.0-alpine3.17
WORKDIR /opt/app
ENV PATH /opt/app/node_modules/.bin:$PATH
COPY package.json /opt/app/package.json
RUN npm install
RUN npm install -g @angular/cli
COPY . /opt/app
CMD ng serve --host 0.0.0.0
