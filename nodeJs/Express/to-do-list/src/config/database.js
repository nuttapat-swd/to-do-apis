const { Sequelize } = require('sequelize');
const envConfig = require('./src/config/env');

const { username, password, database, host, port, dialect } = envConfig.database;

const sequelize = new Sequelize(database, username, password, {
    host: host,
    dialect: dialect,
    port: port,
})

module.exports = sequelize