package com.crazycoder.crazyharborbff.domain.service.harboruser.impl;

import com.crazycoder.crazyharborbff.config.redis.CacheNames;
import com.crazycoder.crazyharborbff.domain.data.entity.HarborUserEntity;
import com.crazycoder.crazyharborbff.domain.repository.HarborUserRepository;
import com.crazycoder.crazyharborbff.domain.service.common.BaseService;
import com.crazycoder.crazyharborbff.domain.service.eventhistory.EventHistoryService;
import com.crazycoder.crazyharborbff.domain.service.harboruser.HarborUserService;
import com.crazycoder.crazyharborbff.domain.service.harboruser.mapper.HarborUserServiceMapper;
import com.crazycoder.crazyharborbff.domain.service.harboruser.model.HarborUserListDTO;
import com.crazycoder.crazyharborbff.domain.service.harboruser.model.HarborUserRequestDTO;
import com.crazycoder.crazyharborbff.domain.service.harboruser.model.HarborUserResponseDTO;
import com.crazycoder.crazyharborbff.domain.service.publisher.impl.PublisherServiceImpl;
import com.crazycoder.crazyharborbff.domain.service.publisher.model.EventHistoryDTO;
import com.crazycoder.crazyharborbff.util.EventConverter;
import com.crazycoder.crazyharborbff.exception.HarborUserServiceException;
import com.crazycoder.crazyharborcommon.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class HarborUserServiceImpl extends BaseService implements HarborUserService {


    private final HarborUserRepository repository;


    private final PublisherServiceImpl publisherService;

    private final EventHistoryService eventHistoryService;

    private final EventConverter eventConverter;


    private final HarborUserServiceMapper mapper = HarborUserServiceMapper.INSTANCE;

    public HarborUserServiceImpl(HarborUserRepository repository, PublisherServiceImpl publisherService, EventHistoryService eventHistoryService, EventConverter eventConverter) {
        this.repository = repository;
        this.publisherService = publisherService;
        this.eventHistoryService = eventHistoryService;
        this.eventConverter = eventConverter;
    }

    @Override
    //@Cacheable(CacheNames.HARBOR_USERS) //  direkt güncelliyor kendini her seferinde
    public List<HarborUserListDTO> getAllHarborUser() {

        List<HarborUserEntity> allHarborUser = repository.findAll();

        List<HarborUserListDTO> harborUserListDTOS = mapper.toHarborUserListDto(allHarborUser);

        log.warn("getAllHarborUser cache'siz çağarıldı.");
        return harborUserListDTOS;
    }

    @Override
    public HarborUserResponseDTO getUser(Long id) {

        HarborUserResponseDTO harborUserResponseDTO = null;
        try {
            Optional<HarborUserEntity> userEntityOptional = repository.findById(id);

            if (userEntityOptional.isPresent()) {
                HarborUserEntity forumUserEntity = userEntityOptional.get();
                harborUserResponseDTO = mapper.toUserResponseDTO(forumUserEntity);
            }
            return harborUserResponseDTO;
        } catch (RuntimeException e) {
            log.error("Exception while getting a user. Exception -> " + e);
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    //@CacheEvict(CacheNames.HARBOR_USERS) //  direkt güncelliyor kendini her seferinde
    public String createUser(HarborUserRequestDTO userRequestDTO) {
        try {
            HarborUserEntity entity = new HarborUserEntity();
            entity.setFirstName(userRequestDTO.getFirstName());
            entity.setLastName(userRequestDTO.getLastName());
            entity.setEmail(userRequestDTO.getEmail());
            entity.setBirthDate(userRequestDTO.getBirthDate());
            entity.setPassword(userRequestDTO.getPassword());
            entity.setCreateDate(LocalDateTime.now());
            entity.setProfileIconId(userRequestDTO.getProfileIconId());
            entity.setRelatedPosts(Collections.emptyList());
            entity.setUserRole(userRequestDTO.getUserRole());




            HarborUserEntity savedEntity = repository.save(entity);
            EventHistoryDTO event = eventConverter.convertToEventHistoryDTO(savedEntity);

            eventHistoryService.createEventHistory(event);

            publisherService.publishUserCreateEvent(JsonUtil.toJson(event));
            return String.valueOf(savedEntity.getId());
        } catch (RuntimeException e) {
            log.error("Exception while creating a user. Exception -> " + e);
            throw new HarborUserServiceException(e.getMessage(), getClass().getSimpleName());
        }

    }


}
