/**
 * Copyright © 2016-2023 The Linkstuffs Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.msa.ui.tests.deviceProfileSmoke;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.thingsboard.server.msa.ui.base.AbstractDriverBaseTest;
import org.thingsboard.server.msa.ui.pages.LoginPageHelper;
import org.thingsboard.server.msa.ui.pages.ProfilesPageHelper;
import org.thingsboard.server.msa.ui.pages.SideBarMenuViewHelper;

public class MakeDeviceProfileDefaultTest extends AbstractDriverBaseTest {
    private SideBarMenuViewHelper sideBarMenuView;
    private ProfilesPageHelper profilesPage;

    @BeforeMethod
    public void login() {
        new LoginPageHelper(driver).authorizationTenant();
        sideBarMenuView = new SideBarMenuViewHelper(driver);
        profilesPage = new ProfilesPageHelper(driver);
    }

    @AfterMethod
    public void makeProfileDefault() {
        testRestClient.setDefaultDeviceProfile(getDeviceProfileByName("default").getId());
    }

    @Test(priority = 10, groups = "smoke")
    @Description
    public void makeDeviceProfileDefaultByRightCornerBtn() {
        sideBarMenuView.openDeviceProfiles();
        profilesPage.setProfileName();
        String profile = profilesPage.getProfileName();
        profilesPage.makeProfileDefaultBtn(profile).click();
        profilesPage.warningPopUpYesBtn().click();

        Assert.assertTrue(profilesPage.defaultCheckbox(profile).isDisplayed());
    }

    @Test(priority = 10, groups = "smoke")
    @Description
    public void makeDeviceProfileDefaultFromView() {
        sideBarMenuView.openDeviceProfiles();
        profilesPage.setProfileName();
        String profile = profilesPage.getProfileName();
        profilesPage.entity(profile).click();
        profilesPage.deviceProfileViewMakeDefaultBtn().click();
        profilesPage.warningPopUpYesBtn().click();
        profilesPage.closeEntityViewBtn().click();

        Assert.assertTrue(profilesPage.defaultCheckbox(profile).isDisplayed());
    }
}
