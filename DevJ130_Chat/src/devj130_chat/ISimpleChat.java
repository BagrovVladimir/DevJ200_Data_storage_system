
package devj130_chat;

public interface ISimpleChat extends AutoCloseable{
    
        /**
     * Стандартный порт, на котором принимается сообщения сервером.
     */
    public static final int SERVER_PORT = 45678;
    /**
     * Стандартный размер буфера обмена.
     */
    public static final int BUFFER_SIZE = 4096;

    /**
     * Запуск приложения в режиме клиента.
     *
     * @throws ChatException выбрасывается в случае общей ошибки в работе
     * приложения, например, в случае невозможности открыть соединение с
     * сервером.
     */
    void client() throws ChatException;

    /**
     *
     * @throws ChatException выбрасывается в случае общей ошибки в работе
     * приложения, например, в случае невозможности занять стандартный порт
     * сервера.
     */
    void server() throws ChatException;

    /**
     * Метод возвращает принятое сообщение.
     *
     * @return @throws ChatException выбрасывается в случае общей ошибки в
     * работе приложения.
     */
    void getMessage() throws ChatException;

    /**
     * Метод отправляет сообщение.
     *
     * @param message отправляемое сообщение.
     * @throws ChatException выбрасывается в случае общей ошибки в работе
     * приложения.
     */
    void sendMessage(String message) throws ChatException;

    /**
     * Метод закрывает открытые сокеты.
     *
     * @throws ChatException выбрасывается в случае общей ошибки в работе
     * приложения.
     */
    @Override
    public void close() throws ChatException;
    
}
