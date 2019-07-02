package hr.dsokac.androidcommons.permissions.callbacks

/**
 * Callback on which permission check results will be returned
 *
 * @author Danijel Sokač
 */
interface PermissionCallback {
    /**
     * All required permissions are allowed by user
     */
    fun onAllowed()

    /**
     * One or more of required permissions is not allowed by user
     */
    fun onDisallowed()
}