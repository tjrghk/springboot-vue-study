<template>  
    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>ROLE</th>
        </tr>
        </thead>
        <tbody>
            <tr v-for="member in getMembers" :key="member.memberSeq">
                <td>{{member.memberId}}</td>
                <td>{{member.memberName}}</td>
                <td>{{member.memberRole === '1' ? "최고관리자" : "일반관리자"}}</td>
            </tr>
        </tbody>
    </table>
</template>

<script>
import { mapGetters } from "vuex";

export default {
    name: "content-view",
    data() {
        return {};
    },
    computed: {
        ...mapGetters(["getMembers"])
    },
    methods: { 
        async members() {  
            try {
                const response = await this.$store.dispatch("members");
                if (response.status == 200) { 
                    console.log("회원조회...")
                } 
            } catch(error) {
                alert(error.message);
            }
        },
    },
    mounted() {
        this.members();
    }
}
</script>

<style scoped>
   
</style>