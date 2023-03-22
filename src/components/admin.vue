<template>
  <div class="home">
    <div style="width:1700px;position: relative;padding: 15px 30px;float: right">
      <el-table
          :data="tableData"
          style="width: 100%;white-space: pre-line"
          height="850"
      >
        <el-table-column
            prop="id"
            label="ID"
            sortable
        >
        </el-table-column>
        >
        <!--        <el-table-column-->
        <!--            type="index"-->
        <!--            width="50">-->
        <!--        </el-table-column>-->
        <el-table-column
            prop="job"
            label="职位"
            width="150">
        </el-table-column>
        <el-table-column
            prop="name"
            label="姓名"
            width="120">
        </el-table-column>
        <el-table-column
            prop="experience"
            label="工作经历"
            width="300">
        </el-table-column>
        <el-table-column
            prop="project"
            label="项目经历"
            width="300">
        </el-table-column>
        <el-table-column
            prop="education"
            label="教育经历"
            width="200">
        </el-table-column>
        <el-table-column
            prop="certificate"
            label="技能证书"
            width="200">
        </el-table-column>
        <!--        <el-table-column-->
        <!--            prop="certificate"-->
        <!--            label="技能证书"-->
        <!--            width="300">-->
        <!--        </el-table-column>-->

        <el-table-column
            prop="phone"
            label="联系方式"
            width="120">
        </el-table-column>
        <el-table-column
            label="操作"
            width="120">
          <template #default="scope">
            <!--          <el-button type="primary" @click="dialogVisible=true">请求</el-button>-->
            <el-button type="primary" @click=qq(scope.row)>请求</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <el-dialog
        title="提示"
        :visible.sync="dialogVisible"
        width="30%">
      <span style="font-size: 20px;">发送请求查看更多信息??</span>
      <span slot="footer" class="dialog-footer">
              <el-button @click="dialogVisible = false">取 消</el-button>
              <el-button type="primary" @click=add()>确 定</el-button>
            </span>
    </el-dialog>

  </div>


</template>

<script>
import request from "@/utils/request";

export default {
  name: "admin",
  components: {},
  data() {
    return {
      data: [],
      audaarr: [],
      user: {},
      // audaList: [{
      //   auname: "",
      //   admin:" ",
      // }],
      qform: {
        user_id: '',
        auname: "",
      },
      dialogVisible: false,
      TDlength: 0,
      experiences: [],
      projects: [],
      educations: [],
      tableData: [{
        job: "",
        name: "",
        experience: "",
        project: "",
        education: "",
        certificate: "",
        phone: "",
        data: [],
      }],
      // tableData: [{
      //   job: "",
      //   name: "",
      //   experience: "",
      //   project:"",
      //   education: "",
      //   certificate: "",
      //   phone: "",
      //   data:[],
      // }
      // ,{
      //   id:"",
      //   job: "",
      //   name: "",
      //   experience: "",
      //   project:"",
      //   education: "",
      //   certificate: "",
      //   phone: "",
      //   data:[],
      // },{
      //   id:"",
      //   job: "",
      //   name: "",
      //   experience: "",
      //   project:"",
      //   education: "",
      //   certificate: "",
      //   phone: "",
      //   data:[],
      // },{
      //   id:"",
      //   job: "",
      //   name: "",
      //   experience: "",
      //   project:"",
      //   education: "",
      //   certificate: "",
      //   phone: "",
      //   data:[],
      // },{
      //   id:"",
      //   job: "",
      //   name: "",
      //   experience: "",
      //   project: "",
      //   education: "",
      //   certificate: "",
      //   phone: "",
      //   data:[],
      //   },{
      //   id:"",
      //   job: "",
      //   name: "",
      //   experience: "",
      //   project:"",
      //   education: "",
      //   certificate: "",
      //   phone: "",
      //   data:[],
      // },{
      //   id:"",
      //   job: "",
      //   name: "",
      //   experience: "",
      //   project:"",
      //   education: "",
      //   certificate: "",
      //   phone: "",
      //   data:[],
      // },{
      //   id:"",
      //   job: "",
      //   name: "",
      //   experience: "",
      //   project:"",
      //   education: "",
      //   certificate: "",
      //   phone: "",
      //   data:[],
      // },{
      //   id:"",
      //   job: "",
      //   name: "",
      //   experience: "",
      //   project:"",
      //   education: "",
      //   certificate: "",
      //   phone: "",
      //   data:[],
      // },{
      //   id:"",
      //   job: "",
      //   name: "",
      //   experience: "",
      //   project:"",
      //   education: "",
      //   certificate: "",
      //   phone: "",
      //   data:[],
      // },{
      //   id:"",
      //   job: "",
      //   name: "",
      //   experience: "",
      //   project:"",
      //   education: "",
      //   certificate: "",
      //   phone: "",
      //   data:[],
      // },{
      //   id:"",
      //   job: "",
      //   name: "",
      //   experience: "",
      //   project:"",
      //   education: "",
      //   certificate: "",
      //   phone: "",
      //   data:[],
      // }],
    }
  },
  created() {
    this.load()
  },
  methods: {
    load() {
      var that = this;
      // this.tableData.length=3;
      // var TDDlength;
      request.get("/role?role=2").then(res => {
        console.log(res);
        console.log(res.data.length);
        that.tableData = res.data.map(res => {
          return {
            ...res,
            name: res.fullname,
          }
        })
        for (var i = 0; i < res.data.length; i++) {
          // that.tableData[i].id=res.data[i].id;
          // that.tableData[i].job=res.data[i].job;
          // that.tableData[i].name=res.data[i].fullname;
          // that.tableData[i].experience=res.data[i].experiencesList[0].company+"："+res.data[i].experiencesList[0].description;
          // that.tableData[i].project=res.data[i].projectsList[0].name+"："+res.data[i].projectsList[0].description;
          // that.tableData[i].education=res.data[i].educationsList[0].degree+"："+res.data[i].educationsList[0].school;
          // that.tableData[i].certificate=res.data[i].certificate;
          that.experiences = res.data[i].experiencesList.map(res => {
            return {
              ...res,
            }
          })
          that.projects = res.data[i].projectsList.map(res => {
            return {
              ...res,
            }
          })
          that.educations = res.data[i].educationsList.map(res => {
            return {
              ...res,
            }
          })
          var string_exxperience = '';
          for (var m = 0; m < that.experiences.length; m++) {
            string_exxperience = that.experiences[m].company + ": " + that.experiences[m].description + "\n";
          }
          var string_project = '';
          for (var n = 0; n < that.projects.length; n++) {
            string_project = that.projects[n].name + ": " + that.projects[n].description + "\n" + string_project;
          }
          var string_education = '';
          for (var b = 0; b < that.educations.length; b++) {
            string_education = that.educations[b].degree + ": " + that.educations[b].school + "\n" + string_education;
          }
          that.tableData[i].experience = string_exxperience;
          that.tableData[i].project = string_project;
          that.tableData[i].education = string_education;
          that.experiences = [];
          that.projects = [];
          that.experiences = [];
          that.tableData[i].data = res.data[i].audaList.map(res => {
            return {
              ...res,
            }
          })
        }

        console.log(that.tableData);
        let userJson = sessionStorage.getItem("user");
        let auname;
        auname = JSON.parse(userJson).username;
        for (var j = 0; j < res.data.length; j++) {
          if(that.tableData[j].data.length==0)
            that.tableData[j].phone = "***********"
          for (var k = 0; k < that.tableData[j].data.length; k++) {
            if ((that.tableData[j].data[k].auname == auname) & (that.tableData[j].data[k].agree)) {
              console.log(that.tableData[j].data[k].auname);
              console.log(that.tableData[j].data[k].agree);
              that.tableData[j].phone = res.data[j].phone;
              break;
            } else {
              that.tableData[j].phone = "***********"
            }
          }
        }
      })
    },
    qq(row) {
      this.dialogVisible = true;
      this.form = JSON.parse(JSON.stringify(row))
      console.log(this.form);
    },
    add() {
      this.dialogVisible = false;
      this.qform.user_id = this.form.id;
      let userJson = sessionStorage.getItem("user");
      this.qform.auname = JSON.parse(userJson).username;
      if (this.form.id) {
        request.post("/auda", this.qform).then(res => {
          if (res.code == '0') {
            this.$message({
              type: "success",
              message: "请求成功",
            })
          }
          if (res.code == '-1') {
            this.$message({
              type: "warning",
              message: "已发送过请求，请耐心等待！",
            })
          }
        })
      }
      // this.tableData.
      // request.post("/qq",this.).then()
    }
  }
}
</script>

<style scoped>
/deep/ .el-table .cell {
  white-space: pre-line;
}

.dialog-footer button:first-child {
  margin-right: 10px;
}
</style>