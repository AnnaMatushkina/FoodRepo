package com.epam.feel.shared.dto;

import java.util.Date;
import java.util.List;
import com.epam.feel.shared.enums.GroupStatus;

/**
 * Helper DTO appending additional column.
 * 
 * @author Michael_Silvanovich
 */
public class ExtendedRequestGroupDTO extends GroupRequestDTO {

    private static final long serialVersionUID = 1172948144012405957L;

    private String menuName;

    public ExtendedRequestGroupDTO() {
        super();
    }

    public ExtendedRequestGroupDTO(Long id, Date createDate, GroupStatus status, List<RequestDTO> requests,
        String menuName) {
        super(id, createDate, status, requests);
        this.menuName = menuName;
    }

    public ExtendedRequestGroupDTO(GroupRequestDTO rg) {
        super(rg.getId(), rg.getCreateDate(), rg.getStatus(), rg.getRequests());
        this.menuName = getRequests().iterator().next().getMenu().getMenuName();
    }

    /**
     * Returns name of menu corresponding to this request group
     * 
     * @return name of menu
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * Sets name of menu not for request group, but only for dto
     * 
     * @param menuName
     *            name of menu
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    @Override
    public void copy(GroupRequestDTO group) {
        super.copy(group);
        if (group instanceof ExtendedRequestGroupDTO) {
            this.menuName = ((ExtendedRequestGroupDTO) group).getMenuName();
        }
    }

}
