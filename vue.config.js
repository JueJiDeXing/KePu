const {defineConfig} = require('@vue/cli-service')
const {VantResolver} = require('@vant/auto-import-resolver');

const ComponentsPlugin = require('unplugin-vue-components/webpack');

module.exports = defineConfig(
    {
        transpileDependencies: true,
        configureWebpack: {
            plugins: [
                (ComponentsPlugin.default || ComponentsPlugin)
                ({resolvers: [VantResolver()]})
            ],
        },
    },
    {
        test: /\.less$/,
        loader: 'style-loader!css-loader!less-loader'
    },
)
