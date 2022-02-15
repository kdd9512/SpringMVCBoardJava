package config;

import mapper.BoardMapper;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// Spring MVC 프로젝트에 관련된 설정을 하는 클래스
@Configuration
// Controller 어노테이션이 셋팅되어 있는 클래스를 Controller로 등록한다.
@EnableWebMvc
// 스캔할 패키지를 지정한다.
@ComponentScan("controller")
@PropertySource("/WEB-INF/properties/db.properties")
public class ServletAppContext implements WebMvcConfigurer{

	// properties 파일에서 값을 주입받음.
	@Value("${db.classname}")
	private String db_classname;

	@Value("${db.url}")
	private String db_url;

	@Value("${db.username}")
	private String db_username;

	@Value("${db.password}")
	private String db_password;

	// Controller의 메서드가 반환하는 jsp의 이름 앞뒤에 경로와 확장자를 붙혀주도록 설정한다.
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.configureViewResolvers(registry);
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
	
	// 정적 파일의 경로를 매핑한다.
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addResourceHandlers(registry);
		registry.addResourceHandler("/webapp/resources/**")
				.addResourceLocations("classpath:/static/");
	}

	// MyBatis 를 위한 설정. DB 접속정보 관리하는 Bean.
	// import 시 반드시 org.apache.commons.dbcp2.BasicDataSource 를 사용해야 한다.
	@Bean
	public BasicDataSource dataSource(){

		BasicDataSource src = new BasicDataSource();
		src.setDriverClassName(db_classname);
		src.setUrl(db_url);
		src.setUsername(db_username);
		src.setPassword(db_password);

		return src;
	}

	// Query 문과 접속 정보를 관리하는 객체.
	@Bean
	public SqlSessionFactory factory(BasicDataSource src) throws Exception {

		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(src);

		return  factoryBean.getObject();
	}

	// Mapper 관리. Query 문 실행을 위한 객체.
	@Bean
	public MapperFactoryBean<BoardMapper> getBoardMapper(SqlSessionFactory factory)
			throws Exception{

		MapperFactoryBean<BoardMapper> factoryBean =
				new MapperFactoryBean<BoardMapper>(BoardMapper.class);

		factoryBean.setSqlSessionFactory(factory);

		return factoryBean;

	}

}










