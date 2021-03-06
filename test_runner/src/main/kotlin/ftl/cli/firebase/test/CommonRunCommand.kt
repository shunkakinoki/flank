package ftl.cli.firebase.test

import picocli.CommandLine

abstract class CommonRunCommand {

    // Flank debug

    @CommandLine.Option(names = ["--dry"], description = ["Dry run on mock server"])
    var dryRun: Boolean = false

    // Flank specific

    @CommandLine.Option(
        names = ["-h", "--help"],
        usageHelp = true,
        description = ["Prints this help message"]
    )
    var usageHelpRequested: Boolean = false

    @CommandLine.Option(
        names = ["--run-timeout"],
        description = ["The max time this test run can execute before it is cancelled (default: unlimited)."]
    )
    var runTimeout: String? = null

    // GcloudYml.kt

    @CommandLine.Option(
        names = ["--results-bucket"],
        description = ["The name of a Google Cloud Storage bucket where raw test " +
                "results will be stored (default: \"test-lab-<random-UUID>\"). Note that the bucket must be owned by a " +
                "billing-enabled project, and that using a non-default bucket will result in billing charges for the " +
                "storage used."]
    )
    var resultsBucket: String? = null

    @CommandLine.Option(
        names = ["--results-dir"],
        description = [
            "The name of a unique Google Cloud Storage object within the results bucket where raw test results will be " +
                    "stored (default: a timestamp with a random suffix). Caution: if specified, this argument must be unique for " +
                    "each test matrix you create, otherwise results from multiple test matrices will be overwritten or " +
                    "intermingled."]
    )
    var resultsDir: String? = null

    @CommandLine.Option(
        names = ["--record-video"],
        description = ["Enable video recording during the test. " +
                "Disabled by default."]
    )
    var recordVideo: Boolean? = null

    @CommandLine.Option(
        names = ["--no-record-video"],
        description = ["Disable video recording during the test (default behavior). Use --record-video to enable."]
    )
    var noRecordVideo: Boolean? = null

    @CommandLine.Option(
        names = ["--timeout"],
        description = ["The max time this test execution can run before it is cancelled " +
                "(default: 15m). It does not include any time necessary to prepare and clean up the target device. The maximum " +
                "possible testing time is 30m on physical devices and 60m on virtual devices. The TIMEOUT units can be h, m, " +
                "or s. If no unit is given, seconds are assumed. "]
    )
    var timeout: String? = null

    @CommandLine.Option(
        names = ["--async"],
        description = ["Invoke a test asynchronously without waiting for test results."]
    )
    var async: Boolean? = null

    @CommandLine.Option(
        names = ["--results-history-name"],
        description = ["The history name for your test results " +
                "(an arbitrary string label; default: the application's label from the APK manifest). All tests which use the " +
                "same history name will have their results grouped together in the Firebase console in a time-ordered test " +
                "history list."]
    )
    var resultsHistoryName: String? = null

    @CommandLine.Option(
        names = ["--num-flaky-test-attempts"],
        description = ["The number of times a TestExecution should be re-attempted if one or more of its test cases " +
                "fail for any reason. The maximum number of reruns allowed is 10. Default is 0, which implies no reruns."]
    )
    var flakyTestAttempts: Int? = null

    // FlankYml.kt

    @CommandLine.Option(
        names = ["--max-test-shards"],
        description = ["The amount of matrices to split the tests across."]
    )
    var maxTestShards: Int? = null

    @CommandLine.Option(
        names = ["--shard-time"],
        description = ["The max amount of seconds each shard should run."]
    )
    var shardTime: Int? = null

    @CommandLine.Option(
        names = ["--num-test-runs"],
        description = ["The amount of times to run the test executions."]
    )
    var repeatTests: Int? = null

    @CommandLine.Option(
        names = ["--smart-flank-gcs-path"],
        description = ["Google cloud storage path to save test timing data used by smart flank."]
    )
    var smartFlankGcsPath: String? = null

    @CommandLine.Option(
        names = ["--smart-flank-disable-upload"],
        description = ["Disables smart flank JUnit XML uploading. Useful for preventing timing data from being updated."]
    )
    var smartFlankDisableUpload: Boolean? = null

    @CommandLine.Option(
        names = ["--disable-sharding"],
        description = ["Disable sharding."]
    )
    var disableSharding: Boolean? = null

    @CommandLine.Option(
        names = ["--test-targets-always-run"],
        split = ",",
        description = [
            "A list of one or more test methods to always run first in every shard."]
    )
    var testTargetsAlwaysRun: List<String>? = null

    @CommandLine.Option(
        names = ["--files-to-download"],
        split = ",",
        description = ["A list of paths that will be downloaded from the resulting bucket " +
                "to the local results folder after the test is complete. These must be absolute paths " +
                "(for example, --files-to-download /images/tempDir1,/data/local/tmp/tempDir2). " +
                "Path names are restricted to the characters a-zA-Z0-9_-./+."]
    )
    var filesToDownload: List<String>? = null

    @CommandLine.Option(
        names = ["--project"],
        description = ["The Google Cloud Platform project name to use for this invocation. " +
                "If omitted, then the project from the service account credential is used"]
    )
    var project: String? = null

    @CommandLine.Option(
        names = ["--local-result-dir"],
        description = ["Saves test result to this local folder. Deleted before each run."]
    )
    var localResultsDir: String? = null
}
