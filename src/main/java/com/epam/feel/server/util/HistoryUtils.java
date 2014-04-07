package com.epam.feel.server.util;

import java.util.Date;
import com.epam.feel.server.model.Account;
import com.epam.feel.server.model.Operation;
import com.epam.feel.server.model.Transaction;
import com.epam.feel.shared.dto.AccountDTO;
import com.epam.feel.shared.dto.MenuDTO;
import com.epam.feel.shared.dto.OperationDTO;
import com.epam.feel.shared.dto.TransactionDTO;
import com.epam.feel.shared.enums.OperationType;
import com.epam.feel.shared.enums.TransactionType;

/**
 * Utility for create DTO objects to save on history.
 * 
 * @author Anna_Gavrilina
 */
public class HistoryUtils {

    private HistoryUtils() {}

    /**
     * Create transaction DTO
     * 
     * @param account
     *            DTO of user account {@link AccountDTO}
     * @param clientName
     *            name of user
     * @param value
     *            changing price to balance
     * @param type
     *            {@link TransactionType}
     * @return instance of {@link TransactionDTO}
     */
    public static TransactionDTO createTransaction(AccountDTO account, String clientName, double value,
        TransactionType type) {
        Account accountEntity = DTOToEntity.convertAccount(account);
        return EntityToDTO.convertTransaction(new Transaction(accountEntity, new Date(), clientName, accountEntity
            .getBalance(), value, type));
    }

    /**
     * Create operation DTO for request or group requests
     * 
     * @param type
     *            {@link OperationType}
     * @param clientName
     *            name of user
     * @param text
     *            message to save history
     * @param operandId
     *            ID of request or group requests
     * @return instance of {@link OperationDTO}
     */
    public static OperationDTO createOperation(OperationType type, String clientName, String body) {
        return EntityToDTO.convertOperation(new Operation(new Date(), clientName, type, body));
    }

    /**
     * Create operation DTO for menu history
     * 
     * @param menuDTO
     *            {@link MenuDTO}
     * @param type
     *            {@link OperationType}
     * @param text
     *            message to save history
     * @param userName
     *            name of user
     * @return instance of {@link OperationDTO}
     */
    public static OperationDTO createMenuOperation(OperationType type, String body, String userName) {
        return EntityToDTO.convertOperation(new Operation(new Date(), userName, type, body));
    }
}
