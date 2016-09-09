<template>
  <div id="app">
    <input v-model="newTodo" v-on:keyup.enter="addTodo">
    <ul>
      <li v-for="todo in todos">
        <span>{{ todo.str }}</span>
      </li>
    </ul>
  </div>
</template>

<script>
  export default {
    data: function () {
      return {
        todos: [],
        newTodo: ''
      }
    },
    ready(){
      this.fetchTodos();
    },
    methods: {
      fetchTodos() {
        this.$http.get("/todo").then(({data}) => this.todos = data)
      },
      addTodo: function () {
        this.$http.post('/todo', {str: this.newTodo, vaild: false}).then(
          ()=> {
            this.todos.push({
              str: this.newTodo,
              vaild: false
            });
            this.newTodo = '';
          }
        )
      }
    }
  }
</script>

<style>
  html {
    height: 100%;
  }

  body {
    display: flex;
    align-items: center;
    justify-content: center;
    height: 100%;
  }

  #app {
    color: #2c3e50;
    margin-top: -100px;
    max-width: 600px;
    font-family: Source Sans Pro, Helvetica, sans-serif;
    text-align: center;
  }

  #app a {
    color: #42b983;
    text-decoration: none;
  }

</style>
