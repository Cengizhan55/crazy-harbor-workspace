package com.crazycoder.crazyharborbff.controller.harboruser;


import com.crazycoder.crazyharborbff.controller.common.BaseController;
import com.crazycoder.crazyharborbff.controller.harboruser.mapper.HarborUserControllerMapper;

import com.crazycoder.crazyharborbff.controller.harboruser.model.HarborUserRequest;
import com.crazycoder.crazyharborbff.controller.harboruser.model.HarborUserResponse;
import com.crazycoder.crazyharborbff.domain.service.harboruser.impl.HarborUserServiceImpl;
import com.crazycoder.crazyharborbff.domain.service.harboruser.model.HarborUserListDTO;
import com.crazycoder.crazyharborbff.domain.service.harboruser.model.HarborUserRequestDTO;
import com.crazycoder.crazyharborbff.domain.service.harboruser.model.HarborUserResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/v1")
public class HarborUserController implements BaseController {

    private final HarborUserServiceImpl userService;

    private final HarborUserControllerMapper mapper = HarborUserControllerMapper.INSTANCE;


    public HarborUserController(HarborUserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<HarborUserResponse> getHarborUser(@PathVariable Long id) {

        HarborUserResponseDTO userResponseDTO = userService.getUser(id);

        return ResponseEntity.ok(mapper.toUserResponse(userResponseDTO));
    }

    @GetMapping("/users")
    public ResponseEntity<List<HarborUserListDTO>> getAllHarborUser() {

        List<HarborUserListDTO> allHarborUser = userService.getAllHarborUser();

        return ResponseEntity.ok(allHarborUser);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody HarborUserRequest request) {


        HarborUserRequestDTO userRequestDTO = mapper.toUserRequestDTO(request);
         String userId = userService.createUser(userRequestDTO);

        return ResponseEntity.ok(userId);
    }
}
