package org.owasp.benchmark.helpers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DependencyInjection {
    public interface Service {
        String execute();
    }

    public class ServiceImpl implements Service {
        private String value;

        public ServiceImpl(String value) {
            this.value = value;
        }

        public String execute() {
            return "";
        }
    }

    public interface ServiceFactory {
        Service create();
    }

    public class ServiceFactoryImpl implements ServiceFactory {
        @Autowired private Service value;

        public Service create() {
            return this.value;
        }
    }

    @Bean
    public Service myService() {
        return new ServiceImpl("");
    }
}
