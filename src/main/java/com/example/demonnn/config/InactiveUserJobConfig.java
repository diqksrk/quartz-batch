//package com.example.demonnn.config;
//
//import com.example.demonnn.entity.User;
//import com.example.demonnn.enums.UserStatus;
//import com.example.demonnn.model.QueueItemReader;
//import com.example.demonnn.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.JobScope;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepScope;
//import org.springframework.batch.item.ItemProcessor;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Slf4j
//@RequiredArgsConstructor
//@Configuration
//public class InactiveUserJobConfig {
//
//    private final UserRepository userRepository;
//    private final JobBuilderFactory jobBuilderFactory;
//    private final StepBuilderFactory stepBuilderFactory;
//
//    @Bean
//    public Job inactiveUserJob() {
//        return jobBuilderFactory.get("inactiveUserJob3")
//                .preventRestart()
//                .start(inactiveJobStep(null))
//                .build();
//    }
//
//    @Bean
//    @JobScope
//    public Step inactiveJobStep(@Value("#{jobParameters[requestDate]}") final String requestDate) {
//        log.info("********** This is inactiveJobStep");
//        log.info("********** This is requestDate of inactiveJobStep : {}",  requestDate);
//
//        return stepBuilderFactory.get("inactiveUserStep")
//                .<User, User>chunk(10)
//                .reader(inactiveUserReader())
//                .processor(inactiveUserProcessor())
//                .writer(inactiveUserWriter())
//                .build();
//    }
//
//    @Bean
//    @StepScope
//    public QueueItemReader<User> inactiveUserReader() {
//        List<User> oldUsers =
//                userRepository.findByUpdatedDateBeforeAndStatusEquals(
//                        LocalDateTime.now().minusYears(1), UserStatus.ACTIVE);
//        return new QueueItemReader<>(oldUsers);
//    }
//
//    public ItemProcessor<User, User> inactiveUserProcessor() {
//        return new org.springframework.batch.item.ItemProcessor<User, User>() {
//            @Override
//            public User process(User user) throws Exception {
//                return user.setInactive();
//            }
//        };
//    }
//
//    public ItemWriter<User> inactiveUserWriter() {
//        return ((List<? extends User> users) -> userRepository.saveAll(users));
//    }
//}