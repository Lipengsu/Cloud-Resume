export default {
    id: '',
    fullName: 'Super',
    job: 'java开发工程师',
    phone: '+86 13577777777',
    email: 'super@163.com',
    links: ["super.me","dadfa"],
    socialNetworks: ["WeChat:super"],
    resume: '本人具有较强的责任心和工作主动性，较好的组织协调能力和应变能力，可以和各个部门的同事相处融洽，配合顺利地完成工作任务。\n'
        + '为人诚实并得到领导的认可!曾去广州、上海等地参加国际性展会，有翻译和外贸经验及出国参展经验!\n'
        + '本人性格开朗，善于沟通，谦虚，自信。虽然新的工作和环境与以往的有所不同，但我相信通过自己的努力和已有的工作基础可以很快胜任\n'
        + '我很有信心!\n',
    experiences: [
        {
            id: 0,
            role: 'Java开发工程师',

            company: '百度',
            fromTo: ['7-2018', '11-2019'],
            isCurrentJob: false,
            description:
                '岗位职责：\n' +
                '1、根据开发规范与流程完成模块的编码； \n' +
                '2、独立进行程序单元、功能的测试，查出软件存在的缺陷并保证其质量； \n' +
                '3、完成开发组长布置的量化工作，独立处理和解决所负责的任务； \n' +
                '4、熟悉该语言，了解软件工程开发流程和实际开发中涉及的技术。',
            tags: ['Java', '软件开发 ', '开发工程师'],
        }
    ],
    projects: [
        {
            id: 0,
            name: '物流信息平台',
            link: '',
            fromTo: ['2-2020', '3-2020'],
            description: '该系统是主要针对物流进行管理的系统。建立一个完善的物流管理系统，能够实现客户订单的生成和拆单，合理安排车辆和司机进行运输调度，有效的仓储管理实现出库订单的拣货、出库；' +
                '使物流工作人员更加高效、准确、方便的开展工作。\n' +
                '\n',
            tags: ['Springboot', 'Vue', 'Mybatis', 'Mysql']
        },
        {
            id: 1,
            name: '线上销售系统',
            link: '',
            fromTo: ['5-2021', '10-2021'],
            description: '该系统是为了拓宽线上销售渠道，增加销售额委托我司开发的一个线上销售系统，主要有产品模块，用户模块，支付模块，订单模块，基础模块等',
            tags: ['Springboot', 'SpringCloud', 'Vue']
        }
    ],
    educations: [
        {
            id: 0,
            degree: '硕士学历',
            school: '萧山达利电子学院',
            fromTo: ['9-2018', '5-2022'],
            description: '学校不断地创新教育理念，深化教学内容、课程体系与实践教学改革，大力推进素质教育，取得了显著成果。',
            tags: []
        }
    ],
    skills: [
        {
            name: 'php',
            level: '中等'
        },
        {
            name: 'js',
            level: '中等'
        },
        {
            name: 'css',
            level: '初学'
        },
    ],
    languages: [
        {
            name: '中文',
            level: '熟练'
        },
        {
            name: '英文',
            level: '流利'
        },
        {
            name: '法语',
            level: '初学'
        }
    ],
    interests: [
        '跑步',
        '游戏',
        '画画'
    ],
    certificate: [
        '计算机二级',
        '蓝桥杯贰等奖',
        'ACM比赛三等奖',
        '英语六级'
    ]
}
