package com.epam.feel.shared.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import com.epam.feel.shared.enums.GroupStatus;

/**
 * Represents DTO group of requests across the application.
 * 
 * @author Anna_Gavrilina
 */
public class GroupRequestDTO extends BaseDTO implements Serializable {
    private static final long serialVersionUID = -4998063305683572831L;

    private Date createDate;
    private GroupStatus status;
    private List<RequestDTO> requests;

    public GroupRequestDTO() {
        super();
    }

    public GroupRequestDTO(Long id, Date createDate, GroupStatus status, List<RequestDTO> requests) {
        super(id);
        this.createDate = createDate;
        this.status = status;
        this.requests = requests;
    }

    public GroupStatus getStatus() {
        return status;
    }

    public void setStatus(GroupStatus status) {
        this.status = status;
    }

    public List<RequestDTO> getRequests() {
        return requests;
    }

    public void setRequests(List<RequestDTO> requests) {
        this.requests = requests;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("[").append(super.toString()).append("Request group date=")
            .append(createDate).append("; Request group status=").append(status).append("; Group of requests=")
            .append(requests).append("]").toString();
    }

    public Double getGroupPrice() {
        Double sum = 0.0;
        if (requests != null) {
            for (RequestDTO req : requests) {
                sum += req.getCost();
            }
        }
        return sum;
    }

    /**
     * Copies all fields from another instance (used to update without replacement)
     * 
     * @param group
     *            - group to be copied
     */
    public void copy(GroupRequestDTO group) {
        setId(group.getId());
        this.createDate = group.createDate;
        this.requests = group.requests;
        this.status = group.status;
    }
}
