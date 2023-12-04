const dotenv = require('dotenv');
const path = require('path');
const envPath = path.join(__dirname, '../../.env');
dotenv.config({ path: envPath}); // Load environment variables from .env file

const env = process.env.NODE_ENV || 'development';

const config = {
    development: {
      database: {
        username: process.env.DB_DEV_USERNAME,
        password: process.env.DB_DEV_PASSWORD,
        database: process.env.DB_DEV_NAME,
        host: process.env.DB_DEV_HOST,
        port: process.env.DB_DEV_PORT,
        dialect: 'postgres', // Example: Use the appropriate database dialect (e.g., postgres, mysql, etc.)
      },
      // Other development environment configurations
    },
    test: {
      database: {
        username: process.env.DB_TEST_USERNAME,
        password: process.env.DB_TEST_PASSWORD,
        database: process.env.DB_TEST_NAME,
        host: process.env.DB_TEST_HOST,
        port: process.env.DB_TEST_PORT,
        dialect: 'postgres',
      },
      // Other test environment configurations
    },
    production: {
      database: {
        username: process.env.DB_PROD_USERNAME,
        password: process.env.DB_PROD_PASSWORD,
        database: process.env.DB_PROD_NAME,
        host: process.env.DB_PROD_HOST,
        port: process.env.DB_PROD_PORT,
        dialect: 'postgres',
      },
      // Other production environment configurations
    },
  };

  module.exports = config[env];