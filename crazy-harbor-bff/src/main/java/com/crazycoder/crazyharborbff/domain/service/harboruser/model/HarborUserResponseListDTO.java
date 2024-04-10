package com.crazycoder.crazyharborbff.domain.service.harboruser.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class HarborUserResponseListDTO implements Serializable {

    List<HarborUserListDTO> harborUsersList;
}
