const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
    devServer : {
        proxy: {
            '/auth': {
              target: 'http://localhost:8080',
              changeOrigin: true
            },
            '/api': {
              target: 'http://localhost:8080',
              changeOrigin: true
            }
          }
    }
  
});
