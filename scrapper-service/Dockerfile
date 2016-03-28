FROM node:4-onbuild
MAINTAINER Mohamed Labouardy <mohamed@labouardy.com>

# Install app dependencies
COPY package.json /src/package.json
RUN cd /src; npm install

# Bundle app source
COPY . /src

# Expose Port

EXPOSE 3000
CMD ["node","/src/server.js"]