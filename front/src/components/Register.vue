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
        <div class="form-group mb-2">
          <label for="memberPassword" class="fw-bold">Password</label>
          <Field v-model="memberPassword" type="password" class="form-control" name="memberPassword" id="memberPassword" title="패스워드" :rules="validate"/>
          <ErrorMessage v-show="!memberPassword" name="memberPassword" class="fw-bold form-text text-danger"/>
        </div>
        <div class="form-group mb-2">
          <label for="memberName" class="fw-bold">Name</label>
          <Field v-model="memberName" type="text" class="form-control" name="memberName" id="memberName" title="이름" :rules="validate"/>
          <ErrorMessage v-show="!memberName" name="memberName" class="fw-bold form-text text-danger"/>
        </div>
        <div class="form-group">
            <label for="memberRole1" class="fw-bold">Role</label>
            <div>
                <div class="form-check-inline">
                    <input v-model="memberRole" class="form-check-input" type="radio" name="memberRole" id="memberRole1" value="1" checked="checked">
                    <label class="form-check-label" for="memberRole1">최고관리자</label>
                </div>
                <div class="form-check-inline">
                    <input v-model="memberRole" class="form-check-input" type="radio" name="memberRole" id="memberRole2" value="2">
                    <label class="form-check-label" for="memberRole2">일반관리자</label>
                </div>
            </div>
        </div>
      </div>
      <div class="mt-5">
          <div class="mt-3 d-flex justify-content-end">
          <button type="button" class="btn btn-outline-success" @click="onLogin">Sign in</button>
          <button type="submit" class="ms-3 btn btn-primary">Sign up</button>
        </div>
      </div>
    </Form>
  </div>
</template>

<script>
import { Form, Field, ErrorMessage} from 'vee-validate'

export default {
  name: 'AdminRegister',  
  components: {
    Form,
    Field,
    ErrorMessage
  },
  data() {
    return {
        memberId: "",
        memberPassword: "",
        memberName: "",
        memberRole: "1"
    }
  },
  methods: {
    onLogin() {
        this.$router.push("login");
    },
    async onSubmitForm() { 
      try { 
        const response = await this.$store.dispatch("register", {
          memberId: this.memberId,
          memberPassword: this.memberPassword,
          memberName: this.memberName,
          memberRole: this.memberRole,
        });

        if (response.status == 200) this.$router.replace("login");
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