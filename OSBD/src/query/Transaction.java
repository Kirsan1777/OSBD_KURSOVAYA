package query;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

/*

public class Transaction {
        private static Transaction instance;
        //private static final Logger LOGGER = LogManager.getLogger();
        private static final int NEGATIVE = -1;

        private Transaction() {

        }

        public static Transaction getInstance() {
            if (instance == null) {
                instance = new Transaction();
            }
            return instance;
        }

        public void createUserAndMoneyAccount(User user, String password, int languageId) throws TransactionException {
            UserDao userDao = UserDaoImplementation.getInstance();
            MoneyAccountDao moneyAccountDao = MoneyAccountDaoImplementation.getInstance();
            Connection connection = null;
            try {
                connection = ConnectionPool.getInstance().getConnection();
                connection.setAutoCommit(false);
                userDao.save(user, password, languageId);
                Optional<User> userToSave = userDao.findByName(user.getUsername());
                if(userToSave.isPresent()) {
                    moneyAccountDao.createUserMoneyAccount(userToSave.get().getId());
                } else{
                    throw new DaoException("For some reason cant find newly created user");
                }
            } catch (ConnectionPoolException | SQLException | DaoException e) {
                rollbackConnection(connection);
                throw new TransactionException("Can't add user and his money account", e);
            } finally {
                closeConnection(connection);
            }
        }

        public void purchaseMembership(int membershipId, double membershipPrice, int userId, String username)
                throws TransactionException {
            UserDao userDao = UserDaoImplementation.getInstance();
            MoneyAccountDao moneyAccountDao = MoneyAccountDaoImplementation.getInstance();
            Connection connection = null;
            try {
                connection = ConnectionPool.getInstance().getConnection();
                connection.setAutoCommit(false);
                BigDecimal price = BigDecimal.valueOf(membershipPrice * NEGATIVE);
                moneyAccountDao.changeMoneyAmount(userId, price);
                userDao.updateMembershipId(username, membershipId);
            } catch (ConnectionPoolException | SQLException | DaoException e) {
                rollbackConnection(connection);
                throw new TransactionException("Can't add user and his money account", e);
            } finally {
                closeConnection(connection);
            }
        }

        private void rollbackConnection(Connection connection) {
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException e) {
                LOGGER.error("Error while rollback transaction: ", e);
            }
        }

        private void closeConnection(Connection connection) {
            if (connection != null) {
                try {
                    connection.setAutoCommit(true);
                    connection.close();
                } catch (SQLException e) {
                    LOGGER.error("Error while closing connection: ", e);
                }
            }
        }
    }
*/