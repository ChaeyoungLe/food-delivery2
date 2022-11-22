<template>

    <v-data-table
        :headers="headers"
        :items="topMenu"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'TopMenuView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "foodId", value: "foodId" },
                { text: "foodNm", value: "foodNm" },
            ],
            topMenu : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/topMenus'))

            temp.data._embedded.topMenus.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.topMenu = temp.data._embedded.topMenus;
        },
        methods: {
        }
    }
</script>

