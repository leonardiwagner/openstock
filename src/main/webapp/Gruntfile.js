module.exports = function(grunt){
  grunt.initConfig({
    pkg: grunt.file.readJSON('package.json'),

    jshint: {
      src: ['*.js'],
      test: ['test/*.js']
    },

    mochaTest: {
      test: {
        options: {
          reporter: 'spec'
        },
        src: ['test/**/*.js']
      }
    },

    watch: {
      src: {
        files: ['*.js'],
        tasks: ['jshint:src','mochaTest']
      },
      test: {
        files: ['test/**/*.js'],
        tasks: ['jshint:test','mochaTest']
      }
    }

  });

  grunt.loadNpmTasks('grunt-contrib-jshint');
  grunt.loadNpmTasks('grunt-mocha-test');
  grunt.loadNpmTasks('grunt-contrib-watch');

  grunt.registerTask('test', ['jshint','mochaTest']);
  grunt.registerTask('default', ['watch']);
};