package com.fngry.muse.mybatis;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.fngry.muse.dao.entity.BaseEntity;

/**
 * @author gaorongyu
 */
public class MyBatisPlusGenerator {

    /** 开发人员 */
    private static final String AUTHOR = "gaorongyu";

    /** 数据库驱动 */
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";

    /** 数据库URL */
    private static final String DB_URL = "jdbc:mysql://localhost:3306/bjminsu" +
            "?useSSL=false&useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&useAffectedRows=true";
    /** 数据库账号 */
    private static final String DB_USERNAME = "root";

    /** 数据库密码 */
    private static final String DB_PASSWORD = "123456";

    /** 父包 */
    private static final String PARENT_PACKAGE = "com.fngry.muse.dao.";
    /** Entity包名 */
    private static final String ENTITY_PACKAGE = PARENT_PACKAGE + "entity";
    /** Mapper包名 */
    private static final String MAPPER_PACKAGE = PARENT_PACKAGE + "mapper";
    /** Mapper XML包名 */
    private static final String MAPPER_XML_PACKAGE = "mapper";
    /** Service包名 */
    private static final String SERVICE_PACKAGE = PARENT_PACKAGE + "dal";
    /** Service Impl包名 */
    private static final String SERVICE_IMPL_PACKAGE = PARENT_PACKAGE + "dal.impl";

    /** 需包含的数据库表 */
    private static final String[] INCLUDE_TABLES = new String[] {
            "wechat_hotel_store"
    };

    /** 代码生成 */
    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        //生成文件的输出目录
        String projectPath = System.getProperty("user.dir");
        globalConfig.setOutputDir(projectPath + "/muse/src/main/java");
        //是否覆盖已有文件，默认false
        globalConfig.setFileOverride(false);
        //是否打开输出目录，默认true
        globalConfig.setOpen(false);
        //是否在xml中添加二级缓存配置，默认false
//        globalConfig.setEnableCache(false);
        //开发人员
        globalConfig.setAuthor(AUTHOR);
        //开启 ActiveRecord 模式，默认false
        globalConfig.setActiveRecord(true);
        //开启 BaseResultMap，默认false
        globalConfig.setBaseResultMap(true);
        //开启 baseColumnList，默认false
//        globalConfig.setBaseColumnList(true);
        //时间类型对应策略
        globalConfig.setDateType(DateType.ONLY_DATE);
        //实体命名方式
        globalConfig.setEntityName("%sEntity");
        //mapper 命名方式
        globalConfig.setMapperName("%sMapper");
        //Mapper xml 命名方式
//        globalConfig.setXmlName("%sMapper");
        //service 命名方式（用到了Mapper，所以作为Dao）
        globalConfig.setServiceName("%sDao");
        //service impl 命名方式
        globalConfig.setServiceImplName("%sDaoImpl");
        //controller 命名方式
//        globalConfig.setControllerName("%Controller");
        //指定生成的主键的ID类型
//        globalConfig.setIdType(IdType.AUTO);
        mpg.setGlobalConfig(globalConfig);

        // 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl(DB_URL);
        // dataSourceConfig.setSchemaName("public");
        dataSourceConfig.setDriverName(DB_DRIVER);
        dataSourceConfig.setUsername(DB_USERNAME);
        dataSourceConfig.setPassword(DB_PASSWORD);
        mpg.setDataSource(dataSourceConfig);

        // 包配置
        PackageConfig packageConfig = new PackageConfig();
        //父包名。如果为空，将下面子包名必须写全部， 否则就只需写子包名
        packageConfig.setParent(null);
        //父包模块名
//        packageConfig.setModuleName("");
        //Entity包名
        packageConfig.setEntity(ENTITY_PACKAGE);
        //Mapper包名
        packageConfig.setMapper(MAPPER_PACKAGE);
        //Mapper XML包名
        packageConfig.setXml(MAPPER_XML_PACKAGE);
        //Service包名
        packageConfig.setService(SERVICE_PACKAGE);
        //Service Impl包名
        packageConfig.setServiceImpl(SERVICE_IMPL_PACKAGE);
        //Controller包名
//        packageConfig.setController(CONTROLLER_PACKAGE);
        mpg.setPackageInfo(packageConfig);

//        //注入配置
//        InjectionConfig cfg = new InjectionConfig() {
//            @Override
//            public void initMap() {
//                // to do nothing
//            }
//        };
//        // 如果模板引擎是 freemarker
//        String templatePath = "/templates/mapper.xml.ftl";
//        // 如果模板引擎是 velocity
//        // String templatePath = "/templates/mapper.xml.vm";
//        // 自定义输出配置
//        List<FileOutConfig> focList = new ArrayList<>();
//        // 自定义配置会被优先输出
//        focList.add(new FileOutConfig(templatePath) {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
//                return projectPath + "/src/main/resources/mapper/" + packageConfig.getModuleName()
//                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
//            }
//        });
//        /*
//        cfg.setFileCreate(new IFileCreate() {
//            @Override
//            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
//                // 判断自定义文件夹是否需要创建
//                checkDir("调用默认方法创建的目录");
//                return false;
//            }
//        });
//        */
//        cfg.setFileOutConfigList(focList);
//        mpg.setCfg(cfg);

        // 模板配置
        TemplateConfig templateConfig = new TemplateConfig();
        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
//        templateConfig.setEntity();
//        templateConfig.setEntityKt();
//        templateConfig.setMapper();
//        templateConfig.setXml();
//        templateConfig.setService();
//        templateConfig.setServiceImpl();
        templateConfig.setController(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        //是否大写命名
        strategyConfig.setCapitalMode(true);
        /*数据库表映射到实体的命名策略，四种类型，从名称就能看出来含义：
            nochange(默认),
            underline_to_camel,(下划线转驼峰)
            remove_prefix,(去除第一个下划线的前部分，后面保持不变)
            remove_prefix_and_camel(去除第一个下划线的前部分，后面转驼峰)*/
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        //数据库表字段映射到实体的命名策略, 未指定按照 naming 执行
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        //表前缀
        strategyConfig.setTablePrefix("");
        //字段前缀
//        strategyConfig.setFieldPrefix("");
        //自定义继承的Entity类全称，带包名
        strategyConfig.setSuperEntityClass(BaseEntity.class.getName());
        //自定义基础的Entity类，公共字段
        strategyConfig.setSuperEntityColumns(
                "id",
                "status",
                "create_by",
                "create_time",
                "update_by",
                "update_time",
                "last_update"
        );
        //自定义继承的Mapper类全称，带包名
//        strategyConfig.setSuperMapperClass(BaseEggMapper.class.getName());
        //自定义继承的Service类全称，带包名
//        strategyConfig.setSuperServiceClass(BaseDao.class.getName());
        //自定义继承的ServiceImpl类全称，带包名
//        strategyConfig.setSuperServiceImplClass(BaseDaoImpl.class.getName());
        //自定义继承的Controller类全称，带包名
//        strategyConfig.setSuperControllerClass("");
        //需要包含的表名，允许正则表达式（与exclude二选一配置）
        strategyConfig.setInclude(INCLUDE_TABLES);
        //需要排除的表名，允许正则表达式（与include二选一配置）
//        strategyConfig.setExclude();
        //【实体】是否生成字段常量（默认 false）
//        strategyConfig.setEntityColumnConstant(true);
        //【实体】是否为构建者模型（默认 false）
//        strategyConfig.setEntityBuilderModel(true);
        //【实体】是否为lombok模型（默认 false）
        strategyConfig.setEntityLombokModel(true);
        //Boolean类型字段是否移除is前缀（默认 false）
        strategyConfig.setEntityBooleanColumnRemoveIsPrefix(true);
        //生成 @RestController 控制器
        strategyConfig.setRestControllerStyle(false);
        //驼峰转连字符
//        strategyConfig.setControllerMappingHyphenStyle(false);
        //是否生成实体时，生成字段注解
        strategyConfig.setEntityTableFieldAnnotationEnable(true);
        //乐观锁属性名称
        strategyConfig.setVersionFieldName("version");
        //逻辑删除属性名称
//        strategyConfig.setLogicDeleteFieldName("deleted");
        //表填充字段
//        strategyConfig.setTableFillList(null);
        mpg.setStrategy(strategyConfig);

//        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

}
