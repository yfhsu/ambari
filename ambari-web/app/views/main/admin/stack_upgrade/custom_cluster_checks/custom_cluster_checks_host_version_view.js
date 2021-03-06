/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


const App = require('app');

App.HostHaveVersionInstalledCheckView = Em.View.extend({
  template: Em.Handlebars.compile([
    '<button class="pull-right btn" {{action reinstall target="view"}} {{bindAttr disabled="view.isDisabled"}}>{{ t common.reinstall }}</button>',
    '<span>{{ item.reason }}</span>'
  ].join('')),
  
  classNames: ['custom-cluster-check'],

  repos: App.RepositoryVersion.find(),
  
  reinstall: function () {
    const repo = App.RepositoryVersion.find(this.get('check').repository_version_id);
    const controller = App.router.get('mainAdminStackAndUpgradeController');
    controller.installRepoVersionConfirmation(repo);
  },
  
  isDisabled: function() {
    return this.get('repos').someProperty('status', 'INSTALLING');
  }.property(
    'repos.@each.status'
  )
});
