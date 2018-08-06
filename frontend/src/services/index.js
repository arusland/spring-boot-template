import Vue from 'vue'
import Promise from 'bluebird'

export default {
  callSimpleService (id) {
    return new Promise((resolve, reject) => {
      Vue.$http.get('/static/' + id + '.json').then(({data}) => {
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  }
}
