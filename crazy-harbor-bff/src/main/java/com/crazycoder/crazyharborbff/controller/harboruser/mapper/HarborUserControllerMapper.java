package com.crazycoder.crazyharborbff.controller.harboruser.mapper;

import com.crazycoder.crazyharborbff.controller.harboruser.model.HarborUserAllResponse;
import com.crazycoder.crazyharborbff.controller.harboruser.model.HarborUserRequest;
import com.crazycoder.crazyharborbff.controller.harboruser.model.HarborUserResponse;
import com.crazycoder.crazyharborbff.domain.service.harboruser.model.HarborUserListDTO;
import com.crazycoder.crazyharborbff.domain.service.harboruser.model.HarborUserRequestDTO;
import com.crazycoder.crazyharborbff.domain.service.harboruser.model.HarborUserResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,componentModel = "spring")
public abstract class HarborUserControllerMapper implements Serializable {

    @Serial
    private static final long serialVersionUID = -8737940067681646267L;

    public static final HarborUserControllerMapper INSTANCE = Mappers.getMapper(HarborUserControllerMapper.class);


    public abstract HarborUserResponse toUserResponse(HarborUserResponseDTO userResponseDTO);

    public abstract HarborUserRequestDTO toUserRequestDTO(HarborUserRequest request);

    public abstract List<HarborUserAllResponse> toHarborUserResponseList(List<HarborUserListDTO> allHarborUser);


}
