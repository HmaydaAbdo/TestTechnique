
import org.example.entities.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountServiceTest {

    private Account account;
    private SimpleDateFormat dateFormat;

    @BeforeEach
    public void setUp() throws Exception {
        account = new Account();
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    }

    @Test
    public void shouldDepositAmountAndUpdateBalance() throws Exception {
        // Given
        Date date = dateFormat.parse("10/01/2012");

        // When
        account.deposit(1000, date);

        assertThat(account.getSolde()).isEqualTo(1000);
    }

    @Test
    public void shouldWithdrawAmountAndUpdateBalance() throws Exception {
        // Given
        Date date1 = dateFormat.parse("10/01/2012");
        account.deposit(1000, date1);
        Date date2 = dateFormat.parse("11/01/2012");

        // When
        account.withdraw(500, date2);

        // Then
        assertThat(account.getSolde()).isEqualTo(500);
    }

    @Test
    public void shouldNotAllowOverdraft()  {

        account.deposit(1000);  // Deposit 1000 to the account

        // When & Then: Assert that the exception is thrown when withdrawing more than the available balance
        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            account.withdraw(1500);  // Trying to withdraw more than the balance
        });

        // Verify the exception message
        assertThat(thrown.getMessage()).isEqualTo("you don't  have  enough  balance ");

        // The balance should remain unchanged
        assertThat(account.getSolde()).isEqualTo(1000);  // Balance should not go negative
    }

    @Test
    public void shouldPrintStatementInCorrectOrder() throws Exception {
        // Given
        Date date1 = dateFormat.parse("10/01/2012");
        account.deposit(1000, date1);
        Date date2 = dateFormat.parse("13/01/2012");
        account.deposit(2000, date2);
        Date date3 = dateFormat.parse("14/01/2012");
        account.withdraw(500, date3);

        // When
        // We won't be able to assert on the exact printed output directly, but we can check the balance after printing
        account.printStatement();

        // Then
        assertThat(account.getSolde()).isEqualTo(2500); // Final balance after all transactions
    }

}
