package com.crazycoder.crazyharborbff.domain.service.harboruser.mapper;

import com.crazycoder.crazyharborbff.domain.data.entity.HarborUserEntity;
import com.crazycoder.crazyharborbff.domain.service.harboruser.model.HarborUserListDTO;
import com.crazycoder.crazyharborbff.domain.service.harboruser.model.HarborUserResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class HarborUserServiceMapper implements Serializable {
    public static final HarborUserServiceMapper INSTANCE = Mappers.getMapper(HarborUserServiceMapper.class);
    @Serial
    private static final long serialVersionUID = -1907642407772551737L;

    public abstract HarborUserResponseDTO toUserResponseDTO(HarborUserEntity forumUserEntity);

    public abstract List<HarborUserListDTO> toHarborUserListDto(List<HarborUserEntity> allHarborUser) ;
}
