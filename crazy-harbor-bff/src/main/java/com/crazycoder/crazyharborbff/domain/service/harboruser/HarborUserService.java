package com.crazycoder.crazyharborbff.domain.service.harboruser;

import com.crazycoder.crazyharborbff.domain.service.harboruser.model.HarborUserListDTO;
import com.crazycoder.crazyharborbff.domain.service.harboruser.model.HarborUserRequestDTO;
import com.crazycoder.crazyharborbff.domain.service.harboruser.model.HarborUserResponseDTO;

import java.util.List;

public interface HarborUserService {
    HarborUserResponseDTO getUser(Long id);

    String createUser(HarborUserRequestDTO userRequestDTO);

    List<HarborUserListDTO> getAllHarborUser();
}
