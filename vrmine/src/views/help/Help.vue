<template>
    <div class="help">
        <!-- 菜单目录 -->
        <div class="nav-menu">
            <div class="search">
                <div class="help-name">使用说明v1.0.0</div>
                <i-input v-model="key_word" placeholder="请输入搜索的内容..." style="width: 220px"></i-input>
            </div>
            <Menu theme="light" accordion v-if="key_word === ''">
                <template v-for="(firstMenu, i) in titleTree">
                    <!-- 不含子标题的一级标题 -->
                    <Menu-item v-if="firstMenu.children.length === 0" :name="i" :key="i">{{ firstMenu.headTitle }}</Menu-item>
                    <!-- 含子标题的一级标题 -->
                    <Submenu v-else :name="i" :key="i">
                        <template slot="title"><span @click="scrollToEl(firstMenu)">{{ firstMenu.headTitle }}</span></template>
                        <template  v-for="(secondMenu, j) in firstMenu.children">
                            <!-- 所有二级标题 -->
                            <Menu-item :name="i.toString() + '-' + j" :key="i.toString() + '-' + j"><span  @click="scrollToEl(secondMenu)">{{ secondMenu.headTitle }}</span></Menu-item>
                            <!-- 不含子标题的二级标题 -->
                            <!-- <Menu-item  v-if="secondMenu.children.length === 0" :name="i.toString() + '-' + j" :key="i.toString() + '-' + j"><span  @click="scrollToEl(secondMenu)">{{ secondMenu.headTitle }}</span></Menu-item> -->
                            <!-- 含子标题的二级标题 -->
                            <!-- <Submenu v-else :name="i.toString() + '-' + j" :key="i.toString() + '-' + j"> -->
                                <!-- <template slot="title"><span @click="scrollToEl(secondMenu)">{{ secondMenu.headTitle }}</span></template> -->
                                <!-- 三级标题 -->
                                <!-- <template  v-for="(thirdMenu, k) in secondMenu"> -->
                                    <!-- <Menu-item :name="i.toString() + '-' + j.toString() + '-' + k" :key="i.toString() + '-' + j.toString() + '-' + k"><span  @click="scrollToEl(secondMenu)">{{ thirdMenu.headTitle }}</span></Menu-item> -->
                                <!-- </template> -->
                            <!-- </Submenu> -->
                        </template>
                    </Submenu>
                </template>
            </Menu>
            <Menu v-else>
                <template v-for="(eqMenu, i) in titleListOfKey">
                    <Menu-item :name="i" :key="i"><span @click="scrollToEl(eqMenu)">{{ eqMenu.headTitle }}</span></Menu-item>
                </template>
            </Menu>
        </div>
        <!-- 正文 -->
        <div class="container">
            <!-- 阅读 -->
            <div class="container-title">{{ titleText }}</div>
            <!-- admin编辑 -->
            <div class="admin-editer">
                <Alert v-if="tip[2]" :type="tip[0]" show-icon closable>
                    {{ tip[1] }}
                    <span slot="desc">{{ tip[2] }}</span>
                </Alert>
                <div v-if="!isEdit" class="container-text" v-html="helpDocText"></div>
                <div v-else class="editor-text">
                    <div ref="editor" class="editor-model"></div>
                    <i-button type="info" @click="getContent">确认修改</i-button>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
import helpText from "./doc/help"
import E from 'wangeditor'

export default {
    name: "help",
    data() {
        return {
            isEdit: false,  // true开启文本编辑
            key_word: "",  // 搜索的关键词
            titleText: "帮助文档",  // 正文标题
            helpDocText: "",  // 正文
            titleList: [],  // 所有标题列表
            titleTree: [],  // 层级标题树
            titleListOfKey: [],  // 带搜索关键词的标题列表
            editorContent: '',  // 编辑模式修改的内容
            tip: []  // 编辑提示
        };
    },
    created() {
        this.helpDocText = helpText;
    },
    mounted() {
        if (this.isEdit) {
            var editor = new E(this.$refs.editor);
            editor.customConfig.onchange = html => {
                this.editorContent = html;
            };
            editor.customConfig.uploadImgShowBase64 = true;
            editor.create();
            editor.txt.html(this.helpDocText);
        }
        this.findRecursion(document.querySelectorAll(".container-text")[0] || document.querySelectorAll(".editor-model")[0], ['H1', 'H2', 'H3']);
        this.createCatalog(this.key_word);
    },
    methods: {
        scrollToEl(item) {
            this.titleText = item.headTitle
            item.element.scrollIntoView()
        },
        findRecursion(parent, labelList) {
            for (var i = 0; i < parent.children.length; i++) {
                if ( labelList.indexOf(parent.children[i].tagName) > -1 ) {
                    this.titleList.push(parent.children[i]);
                }
                this.findRecursion(parent.children[i], labelList);
            }
        },
        getContent() {
            if (this.editorContent == '') {
                this.tip = ['error', '错误', '您未进行任何修改']
                return;
            }
            this.tip = ['success', '成功', '请将控制台生成的内容替换help.js内容(/src/views/help/doc/help.js)']
            console.log('module.exports=`' + this.editorContent + '`;')
            console.log("%c请将上边生成的内容替换help.js全部内容(/src/views/doc/help.js)","color:red");
        },
        createCatalog(key_word) {
            var items = [];
            var interimObj = null;
            var list = [];
            var createElTree = {
                H1: function(v, el) {
                    if (interimObj) {
                        items.push(interimObj);
                    }
                    var obj = {
                        headTitle: v,
                        children: [],
                        element: el
                    };
                    interimObj = obj;
                    if (v.indexOf(key_word) > -1) {
                        list.push({
                            headTitle: v,
                            element: el
                        });
                    }
                },
                H2: function(v, el) {
                    interimObj.children.push({
                        headTitle: v,
                        children: [],
                        element: el
                    });
                    if (v.indexOf(key_word) > -1) {
                        list.push({
                            headTitle: v,
                            element: el
                        });
                    }
                },
                H3: function(v, el) {
                    interimObj.children[
                        interimObj.children.length - 1
                    ].children.push({
                        headTitle: v,
                        element: el
                    });
                    if (v.indexOf(key_word) > -1) {
                        list.push({
                            headTitle: v,
                            element: el
                        });
                    }
                }
            };
            this.titleList.forEach(el => {
                createElTree[el.tagName](el.innerHTML, el);
            })
            items.push(interimObj);
            this.titleTree = items;
            this.titleListOfKey = list;
        }
    },
    watch: {
        key_word() {
            this.createCatalog(this.key_word);
        }
    }
};
</script>
<style scoped>
.help {
    position: relative;
}
.nav-menu {
    position: fixed;
    top: 0;
    bottom: 0;
    width: 240px;
    min-height: 100%;
    overflow-y:scroll;
    overflow-x:hidden;
    border-right: 1px solid #dcdee2;
}
.container {
    position: absolute;
    top: 0;
    left: 250px;
}
/* 左侧导航 */
.help-name {
    height: 47px;
    padding-left: 10px;
    font-size: 16px;
    line-height: 47px;
    font-weight: 700;
    width: 240px;
}
.ivu-input-wrapper {
    margin: 10px !important;
}
/* 右侧正文 */
.container {
    width: calc(100% - 250px);
}
.container-title {
    font-size: 25px;
    font-weight: bolder;
    text-align: center;
    padding: 15px;
}
.container-text {
    padding: 19px;
}
.container-text >>> h1 {
    padding: 15px 0;
    font-size: 32px;
    color: #525252;
}
.container-text >>> h2 {
    padding: 10px 0;
    font-size: 22px;
    color: #525252;
}
.container-text >>> h3 {
    padding: 7px 0;
    font-size: 19px;
    color: #525252;
    font-weight: 400;
}
/* 编辑模式 */
.editor-text {
    margin: 20px;
}
.ivu-btn {
    margin: 15px;
    float: right;
}
</style>