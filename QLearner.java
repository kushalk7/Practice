public class QLearner {

    /**
     * Performs Q-learning.
     *
     * @param rewards matrix of states X rewards where rewards[s][a] denotes
     * reward for action a in state s
     * @param paths array of paths where paths[p] denotes a path
     * @param gamma the learning rate
     * @param noIterations number of iterations Q-learning should be executed
     * @return policy
     */
    public String execute(Integer[][] rewards, Integer[][] paths, Double gamma, Integer noIterations) {
        // Initialize Q
        final Double[][] Q = initializeQ(rewards);

        // Do noIterations of Q-learning
        for (int i = 0; i < noIterations; i++) {
            // For each iteration execute Q-learning for all paths
            for (Integer[] path : paths) {
                execute(Q, rewards, path, gamma);
            }
        }

        // Compute and return the policy
        return policy(Q);
    }

    /**
     * Executes Q-learning for one path.
     *
     * @param Q
     * @param rewards matrix of states X rewards where rewards[s][a] denotes
     * rewards for action a in state s
     * @param path where path[0] is the start state and the following are
     * actions
     * @param gamma the learning rate
     */
    private void execute(Double[][] Q, Integer[][] rewards, Integer[] path, Double gamma) {
        // Do for all states in path
        for (int i = 0; i < path.length - 1; i++) {
            int s = path[i]; // state
            int a = path[i + 1]; // action

            int nextState = a;
            // Get next best action
            int nextBestAction = getBestAction(Q[nextState]);

            // Update Q
            if (nextBestAction >= 0) {
                Q[s][a] = rewards[s][a] + gamma * Q[nextState][nextBestAction];
            } else {
                Q[s][a] = rewards[s][a] + gamma * 0;
            }
        }
    }

    /**
     * Computes the policy string.
     *
     * @param Q
     * @return policy in the format specified by the assignment
     */
    private String policy(Double[][] Q) {
        int size = Q.length;
        String[] bestActions = new String[size];
        // For each state find best action
        for (int s = 0; s < size; s++) {
            int bestAction = getBestAction(Q[s]);
            // If no best action, put "n"
            bestActions[s] = bestAction > -1 ? Integer.toString(bestAction) : "n";
        }

        return String.join(" ", bestActions);
    }

    /**
     * Returns action with highest reward.
     *
     * @param actions array of actions where actions[a] denotes the reward for
     * action a
     * @return if exists, then action with highest reward, else -1
     */
    private int getBestAction(Double[] actions) {
        int bestAction = -1;
        for (int a = 0; a < actions.length; a++) {
            // If action a is possible and reward for action a is better 
            // than the reward for the previous best action,
            if (actions[a] != null && (bestAction == -1
                    || actions[a] > actions[bestAction])) {
                bestAction = a; // then set the new best action
            }
        }

        return bestAction;
    }

    /**
     * Initializes Q with the correct values.
     *
     * @param rewards matrix of states X actions where rewards[s][a] denotes
     * reward for action a in state s
     * @return Q
     */
    private Double[][] initializeQ(Integer[][] rewards) {
        int size = rewards.length;
        Double[][] Q = new Double[size][size];

        // Fill in Q
        for (int s = 0; s < size; s++) {
            for (int a = 0; a < size; a++) {
                if (rewards[s][a] != null) {
                    Q[s][a] = 0.0; // put 0.0 if action a is valid for state s
                } else {
                    Q[s][a] = null; // else put null
                }
            }
        }

        return Q;
    }
}