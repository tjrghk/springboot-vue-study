<template>  
    <Headder></Headder>
        <p v-if="getMemberInfo">안녕하세요. {{ getMemberInfo.memberName }}님</p>
         <router-view></router-view>
    <Footer></Footer>
</template>

<script>
import Headder from "@/view/Header.vue";
import Footer from "@/view/Footer.vue";
import { mapGetters } from "vuex";

export default {
    name: "AdminMain",
    components: { 
        Headder,
        Footer 
    },
    data() {
        return {};
    },
    computed: {
        ...mapGetters(["getMemberInfo"])
    }
    
}
</script>