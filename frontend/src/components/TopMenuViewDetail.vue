<template>

    <v-card outlined>
        <v-card-title>
            TopMenu # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="FoodId" v-model="item.foodId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="FoodNm" v-model="item.foodNm" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'TopMenuViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/topMenus/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

