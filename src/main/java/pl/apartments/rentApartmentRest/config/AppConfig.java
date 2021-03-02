package pl.apartments.rentApartmentRest.config;


import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.Validator;
import java.util.HashSet;
import java.util.Set;

@Configuration
@ComponentScan("pl.apartments")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"pl.apartments.rentApartmentRest.repository"})
public class AppConfig {

    @Bean
    public MessageSource messageSource(){
        ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
        source.setBasename("classpath:messages");
        source.setDefaultEncoding("UTF-8");
        return source;
    }

    @Bean
    public Validator validator(){
        LocalValidatorFactoryBean validatorFactoryBean = new LocalValidatorFactoryBean();
        validatorFactoryBean.setValidationMessageSource(messageSource());
        return validatorFactoryBean;
    }

    @Bean(name = "conversionService")
    public ConversionService getConversionService() {
        ConversionServiceFactoryBean factory = new ConversionServiceFactoryBean();
        factory.setConverters(getConverters());
        factory.afterPropertiesSet();
        return factory.getObject();
    }

    public Set<Converter> getConverters() {
        Set<Converter> converters = new HashSet<>();
        return converters;
    }
}
