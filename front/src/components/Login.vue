<template>        
  <div class="vh-100 bg-light d-flex justify-content-center align-items-center">
    <Form @submit="onSubmitForm" class="d-flex flex-column justify-content-center align-items-center shadow-lg p-3 mb-5 bg-white rounded">
      <div>
          <img class="mb-5" src="https://www.easymedia.net/common/images/logo_t2.png" alt="" />
      </div>
      <div>
        <div class="form-group mb-2">
          <label for="memberId" class="fw-bold">ID</label>
          <Field v-model="memberId" type="text" class="form-control" name="memberId" id="memberId" title="아이디" :rules="validate"/>
          <ErrorMessage v-show="!memberId" name="memberId" class="fw-bold form-text text-danger"/>
        </div>
        <div class="form-group">
          <label for="memberPassword" class="fw-bold">Password</label>
          <Field v-model="memberPassword" type="password" class="form-control" name="memberPassword" id="memberPassword" title="패스워드" :rules="validate"/>
          <ErrorMessage v-show="!memberPassword" name="memberPassword" class="fw-bold form-text text-danger"/>
        </div>
      </div>
      <div class="mt-5">
          <div class="mt-3 d-flex justify-content-end">
          <button type="submit" class="btn btn-outline-success">Sign in</button>
          <button type="button" class="ms-3 btn btn-primary" @click="onRegister">Sign up</button>
        </div>
      </div>
    </Form>
  </div>
</template>

<script>
import { Form, Field, ErrorMessage} from 'vee-validate'

export default {
  name: 'AdminLogin',  
  components: {
    Form,
    Field,
    ErrorMessage
  },
  data() {
    return {
        memberId: null,
        memberPassword: null
    }
  },
  methods: {
    onRegister() {
      this.$router.push("register");
    },
    async onSubmitForm() {  
      try {
        const response = await this.$store.dispatch("login", {  
          memberId: this.memberId,
          memberPassword: this.memberPassword
        });

        if (response.status == 200) this.$router.replace('main');
      } catch(error) {
        alert(error.message);
      }
    },
    validate(value, obj) {
      if(!value) {
        let title = document.querySelector(`#${obj.field}`).title;
        return `${title}를 입력해주세요.`;
      }
      
      return true;
    }
  }
}
</script>

<style scoped >

  form {
    width: 380px;
    height: 660px;
    
  }


</style>