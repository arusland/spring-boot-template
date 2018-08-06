<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <button @click="callService">Call service</button>
    <button @click="callFailService">Call fail service</button>
    <div class="service-result">{{ apiResp }}</div>
    <div class="error" v-if="errorMessage">{{ errorMessage }}</div>
    <br/>
    <br/>
    <router-link to="/" class="btn btn-primary">Back</router-link>
  </div>
</template>

<script>
import service from '../services'

export default {
  name: 'HelloService',
  data () {
    return {
      msg: 'Welcome Service Test Page',
      apiResp: '',
      errorMessage: ''
    }
  },
  methods: {
    callService () {
      this.clearAll()

      service.callSimpleService('data')
        .then(data => { this.apiResp = data.title })
        .catch(error => { this.errorMessage = error })
    },
    callFailService () {
      this.clearAll()

      service.callSimpleService('foobar')
        .then(data => { this.apiResp = data.title })
        .catch(error => { this.errorMessage = error })
    },
    clearAll () {
      this.apiResp = ''
      this.errorMessage = ''
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  h1, h2 {
    font-weight: normal;
  }
  .error {
    color: red;
  }
  .service-result {
    color: #009926;
  }
  a {
    color: #42b983;
  }
</style>
